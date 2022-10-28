package com.zezoo.qurankarem;

import java.io.File;
import java.util.ArrayList;

import android.app.ActionBar;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class List_Activity extends ListActivity {
	// StringArray
	String ifs_name[] = { "1- ”Ê—… «·›« Õ…", "2- ”Ê—… «·»ﬁ—…", "3- ”Ê—… ¬· ⁄„—«‰", "4- ”Ê—… «·‰”«¡", "5- ”Ê—… «·„«∆œ…",
			"6- ”Ê—… «·√‰⁄«„", "7- ”Ê—… «·√⁄—«›", "8- ”Ê—… «·√‰›«·", "9- ”Ê—… «· Ê»…", "10- ”Ê—… ÌÊ‰”", "11- ”Ê—… ÂÊœ",
			"12- ”Ê—… ÌÊ”›", "13- ”Ê—… «·—⁄œ", "14- ”Ê—… ≈»—«ÂÌ„", "15- ”Ê—… «·ÕÃ—", "16- ”Ê—… «·‰Õ·",
			"17- ”Ê—… «·≈”—«¡", "18- ”Ê—… «·ﬂÂ›", "19- ”Ê—… „—Ì„", "20- ”Ê—… ÿÂ", "21- ”Ê—… «·√‰»Ì«¡", "22- ”Ê—… «·ÕÃ",
			"23- ”Ê—… «·„ƒ„‰Ê‰", "24- ”Ê—… «·‰Ê—", "25- ”Ê—… «·›—ﬁ«‰", "26- ”Ê—… «·‘⁄—«¡", "27- ”Ê—… «·‰„·",
			"28- ”Ê—… «·ﬁ’’", "29- ”Ê—… «·⁄‰ﬂ»Ê ", "30- ”Ê—… «·—Ê„", "31- ”Ê—… ·ﬁ„«‰", "32- ”Ê—… «·”Ãœ…",
			"33- ”Ê—… «·√Õ“«»", "34- ”Ê—… ”»√", "35- ”Ê—… ›«ÿ—", "36- ”Ê—… Ì”", "37- ”Ê—… «·’«›« ", "38- ”Ê—… ’",
			"39- ”Ê—… «·“„—", "40- ”Ê—… €«›—", "41- ”Ê—… ›’· ", "42- ”Ê—… «·‘Ê—Ï", "43- ”Ê—… «·“Œ—›", "44- ”Ê—… «·œŒ«‰",
			"45- ”Ê—… «·Ã«ÀÌ…", "46- ”Ê—… «·√Õﬁ«›", "47- ”Ê—… „Õ„œ", "48- ”Ê—… «·› Õ", "49- ”Ê—… «·ÕÃ—« ", "50- ”Ê—… ﬁ",
			"51- ”Ê—… «·–«—Ì« ", "52- ”Ê—… «·ÿÊ—", "53- ”Ê—… «·‰Ã„", "54- ”Ê—… «·ﬁ„—", "55- ”Ê—… «·—Õ„‰",
			"56- ”Ê—… «·Ê«ﬁ⁄…", "57- ”Ê—… «·ÕœÌœ", "58- ”Ê—… «·„Ã«œ·…", "59- ”Ê—… «·Õ‘—", "60- ”Ê—… «·„„ Õ‰…",
			"61- ”Ê—… «·’›", "62- ”Ê—… «·Ã„⁄…", "63- ”Ê—… «·„‰«›ﬁÊ‰", "64- ”Ê—… «· €«»‰", "65- ”Ê—… «·ÿ·«ﬁ",
			"66- ”Ê—… «· Õ—Ì„", "67- ”Ê—… «·„·ﬂ", "68- ”Ê—… «·ﬁ·„", "69- ”Ê—… «·Õ«ﬁ…", "70- ”Ê—… «·„⁄«—Ã",
			"71- ”Ê—… ‰ÊÕ", "72- ”Ê—… «·Ã‰", "73- ”Ê—… «·„“„·", "74- ”Ê—… «·„œÀ—", "75- ”Ê—… «·ﬁÌ«„…",
			"76- ”Ê—… «·≈‰”«‰", "77- ”Ê—… «·„—”·« ", "78- ”Ê—… «·‰»√", "79- ”Ê—… «·‰«“⁄« ", "80- ”Ê—… ⁄»”",
			"81- ”Ê—… «· ﬂÊÌ—", "82- ”Ê—… «·«‰›ÿ«—", "83- ”Ê—… «·„ÿ››Ì‰", "84- ”Ê—… «·«‰‘ﬁ«ﬁ", "85- ”Ê—… «·»—ÊÃ",
			"86- ”Ê—… «·ÿ«—ﬁ", "87- ”Ê—… «·√⁄·Ï", "88- ”Ê—… «·€«‘Ì…", "89- ”Ê—… «·›Ã—", "90- ”Ê—… «·»·œ",
			"91- ”Ê—… «·‘„”", "92- ”Ê—… «··Ì·", "93- ”Ê—… «·÷ÕÏ", "94- ”Ê—… «·‘—Õ", "95- ”Ê—… «· Ì‰", "96- ”Ê—… «·⁄·ﬁ",
			"97- ”Ê—… «·ﬁœ—", "98- ”Ê—… «·»Ì‰…", "99- ”Ê—… «·“·“·…", "100- ”Ê—… «·⁄«œÌ« ", "101- ”Ê—… «·ﬁ«—⁄…",
			"102- ”Ê—… «· ﬂ«À—", "103- ”Ê—… «·⁄’—", "104- ”Ê—… «·Â„“…", "105- ”Ê—… «·›Ì·", "106- ”Ê—… ﬁ—Ì‘",
			"107- ”Ê—… «·„«⁄Ê‰", "108- ”Ê—… «·ﬂÊÀ—", "109- ”Ê—… «·ﬂ«›—Ê‰", "110- ”Ê—… «·‰’—", "111- ”Ê—… «·„”œ",
			"112- ”Ê—… «·≈Œ·«’", "113- ”Ê—… «·›·ﬁ", "114- ”Ê—… «·‰«”" };
	String ifs_reader[] = { "”⁄œ «·€«„œÌ", "⁄»œ «·»«”ÿ ⁄»œ «·’„œ", "„‘«—Ì »‰ —«‘œ «·⁄›«”Ì", "”⁄Êœ «·‘—Ì„",
			"„Õ„Êœ Œ·Ì· «·Õ’—Ì", "„Õ„œ ’œÌﬁ «·„‰‘«ÊÌ", "⁄·Ì Ã«»—", "⁄·Ì «·Õ–Ì›Ì" };
	// SharedPreferences
	SharedPreferences prefs, prefs1;
	// Editor
	Editor edit_prefs;
	// int
	int reader_index, song_index;
	// String
	String MEDIA_PATH;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.playlist);
		setSpinner();
		setList();
		setReaderPrefs();
		

	}

	private void setSpinner() {
		prefs = getSharedPreferences("reader_file", MODE_PRIVATE);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(List_Activity.this,
				android.R.layout.simple_dropdown_item_1line, ifs_reader);
		final ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		actionBar.setSelectedNavigationItem(prefs.getInt("reader_key", 0));
		ActionBar.OnNavigationListener action = new ActionBar.OnNavigationListener() {

			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				prefs = getSharedPreferences("reader_file", MODE_PRIVATE);
				edit_prefs = prefs.edit();
				edit_prefs.putInt("reader_key", itemPosition);
				edit_prefs.commit();
				
				reader_index = itemPosition;
				setReaderPath();
				return false;
			}
		};
		actionBar.setListNavigationCallbacks(adapter1, action);

	}

	private void setList() {
		ListView lst = new ListView(this);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(List_Activity.this,
				android.R.layout.simple_expandable_list_item_1, ifs_name);
		lst.setAdapter(adapter);
		setListAdapter(lst.getAdapter());

	}

	private void setReaderPrefs() {
		prefs = getSharedPreferences("reader_file", MODE_PRIVATE);
		edit_prefs = prefs.edit();
		reader_index = prefs.getInt("reader_key", 0);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		song_index = position;
		playSongAndOut();
	}

	private void playSongAndOut() {
		Intent i = new Intent(List_Activity.this , AndroidBuildingMusicPlayerActivity.class);
		i.putExtra("media_path", MEDIA_PATH);
		i.putExtra("song_name", ifs_name[song_index]);
		i.putExtra("reader_name", ifs_reader[reader_index]);
		finish();
		startActivity(i);
		
		
	}

	public String setPathAndPlay(int i, Context context) {
		String case_ = null;
		switch (i) {
		case 0:
			MEDIA_PATH = MEDIA_PATH + "/" + ifs_name[song_index] + ".mp3";
			File f1 = new File(MEDIA_PATH);
			if (f1.exists()) {
				prefs1 = getSharedPreferences("reader_file", MODE_PRIVATE);
				Editor edi = prefs1.edit();
				edi.putString("media_path", MEDIA_PATH);
				edi.putInt("song_index", song_index);
				edi.commit();
				case_ = MEDIA_PATH;
				Intent in = new Intent(getApplicationContext(), AndroidBuildingMusicPlayerActivity.class);
				setResult(100, in);
				finish();
			} else {
				Toast.makeText(getApplicationContext(), "Ì—ÃÏ  Õ„Ì· «·”Ê—… · ‘€Ì·Â«", 1500).show();
			}
			break;
		case 1:
			prefs = getSharedPreferences("reader_file", MODE_PRIVATE);
			reader_index = prefs.getInt("reader_key", 0);
			int song_prev = prefs.getInt("song_index", song_index);
			MEDIA_PATH = MEDIA_PATH + "/" + ifs_name[song_prev] + ".mp3";
			File f2 = new File(MEDIA_PATH);
			if (f2.exists()) {
				prefs1 = getSharedPreferences("reader_file", MODE_PRIVATE);
				Editor edi = prefs1.edit();
				edi.putString("media_path", MEDIA_PATH);
				edi.putInt("song_index", song_index);
				edi.commit();
				case_ = MEDIA_PATH;
			} else {
				Toast.makeText(getApplicationContext(), "Ì—ÃÏ  Õ„Ì· «·”Ê—… · ‘€Ì·Â«", 1500).show();
			}
			break;
		case 2:
			prefs = getSharedPreferences("reader_file", MODE_PRIVATE);
			reader_index = prefs.getInt("reader_key", 0);
			int song_next = prefs.getInt("song_index", song_index);
			MEDIA_PATH = MEDIA_PATH + "/" + ifs_name[song_next] + ".mp3";
			File f3 = new File(MEDIA_PATH);
			if (f3.exists()) {
				prefs1 = getSharedPreferences("raeder_file", MODE_PRIVATE);
				Editor edi = prefs1.edit();
				edi.putString("media_path", MEDIA_PATH);
				edi.putInt("song_index", song_index);
				edi.commit();
				case_ = MEDIA_PATH;
			} else {
				Toast.makeText(getApplicationContext(), "Ì—ÃÏ  Õ„Ì· «·”Ê—… · ‘€Ì·Â«", 1500).show();
			}
			break;
		case 4:
			prefs = context.getSharedPreferences("reader_file", 0);
			reader_index = prefs.getInt("reader_key", 0);
			setReaderPath();
			MEDIA_PATH = MEDIA_PATH + "/" + ifs_name[song_index] + ".mp3";
			File f4 = new File(MEDIA_PATH);
			if (f4.exists()) {
				prefs1 = getSharedPreferences("reader_file", MODE_PRIVATE);
				Editor edi = prefs1.edit();
				edi.putString("media_path", MEDIA_PATH);
				edi.putInt("song_index", song_index);
				edi.commit();
				case_ = MEDIA_PATH;
			} else {
				Toast.makeText(context, "Ì—ÃÏ  Õ„Ì· «·”Ê—… · ‘€Ì·Â«", 1500).show();
			}
			break;
		}
		return case_;

	}

	public void setReaderPath() {
		// TODO Auto-generated method stub
		switch (reader_index) {
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

	public void whenComplete() {

	}

	public void whenNext() {

	}

	public void whenPrevious() {

	}


	@Override
	public void onBackPressed() {
		Intent i = new Intent(getApplicationContext(), AndroidBuildingMusicPlayerActivity.class);
		setResult(99, i);
		finish();
		super.onBackPressed();
	}

}
