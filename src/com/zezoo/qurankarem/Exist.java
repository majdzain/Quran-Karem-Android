package com.zezoo.qurankarem;

import java.io.File;

public class Exist {
	File f1 = new File("/mnt/sdcard/qurankarem/Souar/ÓÚÏ ÇáÛÇãÏí-ÓæÑÉ ÇáİÇÊÍÉ.mp3");

	public boolean c1(int r) {
		boolean bool = false;
		switch (r) {
		case 0:
            if(f1.exists())
            	bool = true;
			break;
		case 1:

			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		case 7:

			break;
		}
		return bool;
	}

}
