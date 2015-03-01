package com.utilities;

import java.util.Comparator;

public class cellInfoComparator implements Comparator<cellInfo>{

	@Override
	public int compare(cellInfo o1, cellInfo o2) {
		
		if(o1.getCount()>o2.getCount())
			return 1;
		else
		return 0;
	}

}
