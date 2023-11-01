
public class FindPath {
	Map pyramidMap;

	/**
	 * Parameterized constructor
	 * @param fileName filename of the map
	 * @throws InvalidMapCharacterException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public FindPath(String fileName) throws InvalidMapCharacterException {
		try {
			pyramidMap = new Map(fileName);
		} catch (java.io.FileNotFoundException e) {
			System.out.printf("File %s not found\n", fileName);
			e.printStackTrace();
		} catch (java.io.IOException e) {
			System.out.printf("Error in accessing file %s\n", fileName);
			e.printStackTrace();
		}
	}

	/**
	 * calculate the entrance path of the treasure hunt
	 * @return Stack of the path.
	 */
	public DLStack<Chamber> path() {
		int chambers = pyramidMap.getNumTreasures();
		int count = 0;
		DLStack<Chamber> stack = new DLStack<Chamber>();
		Chamber chamber = pyramidMap.getEntrance();
		chamber.markPushed();
		stack.push(chamber);
		while (!stack.isEmpty()) {
			chamber = stack.peek();
			if (chamber.isTreasure())
				count++;
				if (count == chambers) break;
				Chamber c = bestChamber(chamber);
				if (c != null) {
					stack.push(c);
					c.markPushed();
					continue;
				}
				chamber = stack.pop();
				chamber.markPopped();
		}
		return stack;
	}

	/**
	 * Get the map in map structure.
	 * @return map
	 */
	public Map getMap() {
		return pyramidMap;
	}

	/**
	 * Checks for the Dim chamber
	 * @param currentChamber chamber
	 * @return true if chamber is dim
	 */
	public boolean isDim(Chamber currentChamber) {
		boolean ret = false;
		if (currentChamber == null || currentChamber.isLighted() || currentChamber.isSealed())
			return ret;
		for (int i = 0; i <= 5; i++) {
			try {
				if (currentChamber.getNeighbour(i).isLighted()) {
					ret = true;
					break;
				}
			} catch (NullPointerException e) {
				continue;
			}
		}
		return ret;
	}

	/**
	 * Check for the best chamber to be found in the neighbours
	 * @param currentChamber Chamber
	 * @return the best chamber found
	 */
	public Chamber bestChamber(Chamber currentChamber) {
		for (int j = 0; j < 3; j++)
			for (int i = 0; i < 6; i++) {
				try {
					Chamber chamber = currentChamber.getNeighbour(i);
					if (!chamber.isMarked())
						switch (j) {
							case 0:
								if (chamber.isTreasure())
									return chamber;
								break;
							case 1:
								if (chamber.isLighted())
									return chamber;
								break;
							case 2:
								if (isDim(chamber))
									return chamber;
								break;
						}
				} catch (NullPointerException e) {
					continue;
				}
			}

		return null;
	}
}
