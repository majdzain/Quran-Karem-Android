package com.zezoo.qurankarem;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;

public class SongsManager {
	// SDCard Path
	File Root, Dir;

	String MEDIA_PATH;
	private ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
	File home;
	String ifs_song[] = { "”Ê—… «·›« Õ…", "”Ê—… «·»ﬁ—…", "”Ê—… ¬· ⁄„—«‰",
			"”Ê—… «·‰”«¡", "”Ê—… «·„«∆œ…", "”Ê—… «·√‰⁄«„", "”Ê—… «·√⁄—«›",
			"”Ê—… «·√‰›«·", "”Ê—… «· Ê»…", "”Ê—… ÌÊ‰”", "”Ê—… ÂÊœ",
			"”Ê—… ÌÊ”›", "”Ê—… «·—⁄œ", "”Ê—… ≈»—«ÂÌ„", "”Ê—… «·ÕÃ—",
			"”Ê—… «·‰Õ·", "”Ê—… «·≈”—«¡", "”Ê—… «·ﬂÂ›", "”Ê—… „—Ì„", "”Ê—… ÿÂ",
			"”Ê—… «·√‰»Ì«¡", "”Ê—… «·ÕÃ", "”Ê—… «·„ƒ„‰Ê‰", "”Ê—… «·‰Ê—",
			"”Ê—… «·›—ﬁ«‰", "”Ê—… «·‘⁄—«¡", "”Ê—… «·‰„·", "”Ê—… «·ﬁ’’",
			"”Ê—… «·⁄‰ﬂ»Ê ", "”Ê—… «·—Ê„", "”Ê—… ·ﬁ„«‰", "”Ê—… «·”Ãœ…",
			"”Ê—… «·√Õ“«»", "”Ê—… ”»√", "”Ê—… ›«ÿ—", "”Ê—… Ì”", "”Ê—… «·’«›« ",
			"”Ê—… ’", "”Ê—… «·“„—", "”Ê—… €«›—", "”Ê—… ›’· ", "”Ê—… «·‘Ê—Ï",
			"”Ê—… «·“Œ—›", "”Ê—… «·œŒ«‰", "”Ê—… «·Ã«ÀÌ…", "”Ê—… «·√Õﬁ«›",
			"”Ê—… „Õ„œ", "”Ê—… «·› Õ", "”Ê—… «·ÕÃ—« ", "”Ê—… ﬁ",
			"”Ê—… «·–«—Ì« ", "”Ê—… «·ÿÊ—", "”Ê—… «·‰Ã„", "”Ê—… «·ﬁ„—",
			"”Ê—… «·—Õ„‰", "”Ê—… «·Ê«ﬁ⁄…", "”Ê—… «·ÕœÌœ", "”Ê—… «·„Ã«œ·…",
			"”Ê—… «·Õ‘—", "”Ê—… «·„„ Õ‰…", "”Ê—… «·’›", "”Ê—… «·Ã„⁄…",
			"”Ê—… «·„‰«›ﬁÊ‰", "”Ê—… «· €«»‰", "”Ê—… «·ÿ·«ﬁ", "”Ê—… «· Õ—Ì„",
			"”Ê—… «·„·ﬂ", "”Ê—… «·ﬁ·„", "”Ê—… «·Õ«ﬁ…", "”Ê—… «·„⁄«—Ã",
			"”Ê—… ‰ÊÕ", "”Ê—… «·Ã‰", "”Ê—… «·„“„·", "”Ê—… «·„œÀ—",
			"”Ê—… «·ﬁÌ«„…", "”Ê—… «·≈‰”«‰", "”Ê—… «·„—”·« ", "”Ê—… «·‰»√",
			"”Ê—… «·‰«“⁄« ", "”Ê—… ⁄»”", "”Ê—… «· ﬂÊÌ—", "”Ê—… «·«‰›ÿ«—",
			"”Ê—… «·„ÿ››Ì‰", "”Ê—… «·«‰‘ﬁ«ﬁ", "”Ê—… «·»—ÊÃ", "”Ê—… «·ÿ«—ﬁ",
			"”Ê—… «·√⁄·Ï", "”Ê—… «·€«‘Ì…", "”Ê—… «·›Ã—", "”Ê—… «·»·œ",
			"”Ê—… «·‘„”", "”Ê—… «··Ì·", "”Ê—… «·÷ÕÏ", "”Ê—… «·‘—Õ",
			"”Ê—… «· Ì‰", "”Ê—… «·⁄·ﬁ", "”Ê—… «·ﬁœ—", "”Ê—… «·»Ì‰…",
			"”Ê—… «·“·“·…", "”Ê—… «·⁄«œÌ« ", "”Ê—… «·ﬁ«—⁄…", "”Ê—… «· ﬂ«À—",
			"”Ê—… «·⁄’—", "”Ê—… «·Â„“…", "”Ê—… «·›Ì·", "”Ê—… ﬁ—Ì‘",
			"”Ê—… «·„«⁄Ê‰", "”Ê—… «·ﬂÊÀ—", "”Ê—… «·ﬂ«›—Ê‰", "”Ê—… «·‰’—",
			"”Ê—… «·„”œ", "”Ê—… «·≈Œ·«’", "”Ê—… «·›·ﬁ", "”Ê—… «·‰«”" };

	// Constructor
	public SongsManager(int reader_now) {
		switch (reader_now) {
		case 0:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/saad-el-ghamidi";
			break;
		case 1:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/abdel-basset";
			break;
		case 2:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/mishary-rashid-alafasy";
			break;
		case 3:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/saud-shuraim";
			break;
		case 4:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/mahmoud-khalil-al-hussary";
			break;
		case 5:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/mohamed-seddik-el-menchaoui";
			break;
		case 6:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/ali-jaber";
			break;
		case 7:
			MEDIA_PATH = "/mnt/sdcard/qurankarem/Souar/ali-al-hodhaifi";
			break;
		}
	}

	/**
	 * Function to read all mp3 files from sdcard and store the details in
	 * ArrayList
	 * */
	public ArrayList<HashMap<String, String>> getPlayList() {
		try {
			home = new File(MEDIA_PATH);

			if (home.listFiles(new FileExtensionFilter()).length > 0) {
				for (File file : home.listFiles(new FileExtensionFilter())) {
					HashMap<String, String> song = new HashMap<String, String>();
					song.put(
							"songTitle",
							file.getName().substring(0,
									(file.getName().length() - 4)));
					song.put("songPath", file.getPath());

					songsList.add(song);
				}
			}
		} catch (Exception e) {
		}

		// return songs list array
		return songsList;
	}

	/**
	 * Class to filter files which are having .mp3 extension
	 * */
	class FileExtensionFilter implements FilenameFilter {
		public boolean accept(File dir, String name) {
			
			return (name.endsWith(".mp3") || name.endsWith(".MP3"));
		}
	}
}
