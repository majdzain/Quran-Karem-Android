package com.zezoo.qurankarem;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Spinner;
import android.widget.Toast;

public class DownloadActivity extends Activity implements
		OnCheckedChangeListener {
	DownloadManager downloadManager;
	CheckBox a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15,
			a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28,
			a29, a30, a31, a32, a33, a34, a35, a36, a37, a38, a39, a40, a41,
			a42, a43, a44, a45, a46, a47, a48, a49, a50, a51, a52, a53, a54,
			a55, a56, a57, a58, a59, a60, a61, a62, a63, a64, a65, a66, a67,
			a68, a69, a70, a71, a72, a73, a74, a75, a76, a77, a78, a79, a80,
			a81, a82, a83, a84, a85, a86, a87, a88, a89, a90, a91, a92, a93,
			a94, a95, a96, a97, a98, a99, a100, a101, a102, a103, a104, a105,
			a106, a107, a108, a109, a110, a111, a112, a113, a114,
			un_sellect_all;
	String ifs_name[] = { "1- ”Ê—… «·›« Õ…", "2- ”Ê—… «·»ﬁ—…", "3- ”Ê—… ¬· ⁄„—«‰",
			"4- ”Ê—… «·‰”«¡", "5- ”Ê—… «·„«∆œ…", "6- ”Ê—… «·√‰⁄«„", "7- ”Ê—… «·√⁄—«›",
			"8- ”Ê—… «·√‰›«·", "9- ”Ê—… «· Ê»…", "10- ”Ê—… ÌÊ‰”", "11- ”Ê—… ÂÊœ",
			"12- ”Ê—… ÌÊ”›", "13- ”Ê—… «·—⁄œ", "14- ”Ê—… ≈»—«ÂÌ„", "15- ”Ê—… «·ÕÃ—",
			"16- ”Ê—… «·‰Õ·", "17- ”Ê—… «·≈”—«¡", "18- ”Ê—… «·ﬂÂ›", "19- ”Ê—… „—Ì„", "20- ”Ê—… ÿÂ",
			"21- ”Ê—… «·√‰»Ì«¡", "22- ”Ê—… «·ÕÃ", "23- ”Ê—… «·„ƒ„‰Ê‰", "24- ”Ê—… «·‰Ê—",
			"25- ”Ê—… «·›—ﬁ«‰", "26- ”Ê—… «·‘⁄—«¡", "27- ”Ê—… «·‰„·", "28- ”Ê—… «·ﬁ’’",
			"29- ”Ê—… «·⁄‰ﬂ»Ê ", "30- ”Ê—… «·—Ê„", "31- ”Ê—… ·ﬁ„«‰", "32- ”Ê—… «·”Ãœ…",
			"33- ”Ê—… «·√Õ“«»", "34- ”Ê—… ”»√", "35- ”Ê—… ›«ÿ—", "36- ”Ê—… Ì”", "37- ”Ê—… «·’«›« ",
			"38- ”Ê—… ’", "39- ”Ê—… «·“„—", "40- ”Ê—… €«›—", "41- ”Ê—… ›’· ", "42- ”Ê—… «·‘Ê—Ï",
			"43- ”Ê—… «·“Œ—›", "44- ”Ê—… «·œŒ«‰", "45- ”Ê—… «·Ã«ÀÌ…", "46- ”Ê—… «·√Õﬁ«›",
			"47- ”Ê—… „Õ„œ", "48- ”Ê—… «·› Õ", "49- ”Ê—… «·ÕÃ—« ", "50- ”Ê—… ﬁ",
			"51- ”Ê—… «·–«—Ì« ", "52- ”Ê—… «·ÿÊ—", "53- ”Ê—… «·‰Ã„", "54- ”Ê—… «·ﬁ„—",
			"55- ”Ê—… «·—Õ„‰", "56- ”Ê—… «·Ê«ﬁ⁄…", "57- ”Ê—… «·ÕœÌœ", "58- ”Ê—… «·„Ã«œ·…",
			"59- ”Ê—… «·Õ‘—", "60- ”Ê—… «·„„ Õ‰…", "61- ”Ê—… «·’›", "62- ”Ê—… «·Ã„⁄…",
			"63- ”Ê—… «·„‰«›ﬁÊ‰", "64- ”Ê—… «· €«»‰", "65- ”Ê—… «·ÿ·«ﬁ", "66- ”Ê—… «· Õ—Ì„",
			"67- ”Ê—… «·„·ﬂ", "68- ”Ê—… «·ﬁ·„", "69- ”Ê—… «·Õ«ﬁ…", "70- ”Ê—… «·„⁄«—Ã",
			"71- ”Ê—… ‰ÊÕ", "72- ”Ê—… «·Ã‰", "73- ”Ê—… «·„“„·", "74- ”Ê—… «·„œÀ—",
			"75- ”Ê—… «·ﬁÌ«„…", "76- ”Ê—… «·≈‰”«‰", "77- ”Ê—… «·„—”·« ", "78- ”Ê—… «·‰»√",
			"79- ”Ê—… «·‰«“⁄« ", "80- ”Ê—… ⁄»”", "81- ”Ê—… «· ﬂÊÌ—", "82- ”Ê—… «·«‰›ÿ«—",
			"83- ”Ê—… «·„ÿ››Ì‰", "84- ”Ê—… «·«‰‘ﬁ«ﬁ", "85- ”Ê—… «·»—ÊÃ", "86- ”Ê—… «·ÿ«—ﬁ",
			"87- ”Ê—… «·√⁄·Ï", "88- ”Ê—… «·€«‘Ì…", "89- ”Ê—… «·›Ã—", "90- ”Ê—… «·»·œ",
			"91- ”Ê—… «·‘„”", "92- ”Ê—… «··Ì·", "93- ”Ê—… «·÷ÕÏ", "94- ”Ê—… «·‘—Õ",
			"95- ”Ê—… «· Ì‰", "96- ”Ê—… «·⁄·ﬁ", "97- ”Ê—… «·ﬁœ—", "98- ”Ê—… «·»Ì‰…",
			"99- ”Ê—… «·“·“·…", "100- ”Ê—… «·⁄«œÌ« ", "101- ”Ê—… «·ﬁ«—⁄…", "102- ”Ê—… «· ﬂ«À—",
			"103- ”Ê—… «·⁄’—", "104- ”Ê—… «·Â„“…", "105- ”Ê—… «·›Ì·", "106- ”Ê—… ﬁ—Ì‘",
			"107- ”Ê—… «·„«⁄Ê‰", "108- ”Ê—… «·ﬂÊÀ—", "109- ”Ê—… «·ﬂ«›—Ê‰", "110- ”Ê—… «·‰’—",
			"111- ”Ê—… «·„”œ", "112- ”Ê—… «·≈Œ·«’", "113- ”Ê—… «·›·ﬁ", "114- ”Ê—… «·‰«”" };
	String ifs2_name[] = { "”⁄œ «·€«„œÌ", "⁄»œ «·»«”ÿ ⁄»œ «·’„œ",
			"„‘«—Ì »‰ —«‘œ «·⁄›«”Ì", "”⁄Êœ «·‘—Ì„", "„Õ„Êœ Œ·Ì· «·Õ’—Ì",
			"„Õ„œ ’œÌﬁ «·„‰‘«ÊÌ", "⁄·Ì Ã«»—", "⁄·Ì «·Õ–Ì›Ì" };
	String ifs3_name[] = { "re0", "re1", "re2", "re3", "re4", "re5", "re6",
			"re7" };
	Spinner spinner;
	Exist exist;
	int current_reader = 0;
	URL Url;
	int down_name[];
	int num_name = 0;
	boolean down_with;
	int num_arr[] = new int[114];
	int current_name;
	private long myDownloadReference;
	private BroadcastReceiver receveirDownloadComplete;
	private BroadcastReceiver receveirNotificationClicked;
	boolean isOnline;

	File folder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_download);
		is_online();
		init();
		pref();
		receveirDownloadComplete = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				String action = intent.getAction();
				if (action.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
						&& down_with) {
					if (current_name == 114) {
						Toast.makeText(getBaseContext(), "√ﬂ „· «· Õ„Ì·...",
								1500).show();
					} else {
						download_file(current_name++);
					}
				} else if (action
						.equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
						&& !down_with) {
					Toast.makeText(getBaseContext(), "«· Õ„Ì· √ﬂ „·...", 1500)
							.show();
				}

			}
		};
		registerReceiver(receveirDownloadComplete, new IntentFilter(
				DownloadManager.ACTION_DOWNLOAD_COMPLETE));
		folder = new File(Environment.getExternalStorageDirectory()
				+ "/QuranKarem/Souar");
		if (!folder.exists()) {
			folder.mkdir();
		}
		spinner = (Spinner) findViewById(R.id.reader);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				current_reader = position;

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void is_online() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting()
				|| cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
						.isConnectedOrConnecting()) {
			Toast.makeText(getApplicationContext(), "„ ’· »«·√‰ —‰ ", 1500)
					.show();
		} else {
			Toast.makeText(getApplicationContext(), "!€Ì— „ ’· »«·√‰ —‰ ", 1500)
					.show();
		}

	}

	private void pref() {

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (buttonView.getId() == R.id.select_all) {
			down_with = true;
		} else {
			down_with = false;
		}
		is_online_1();
		if (isOnline) {
			if (isChecked) {
				switch (buttonView.getId()) {
				case R.id.checkBox1:
					DownloadManager.Request request1 = new DownloadManager.Request(
							Uri.parse(set_url(0)));
					request1.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[0])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar/" + getReaderFolder(),
									ifs_name[0] + ".mp3");
					downloadManager.enqueue(request1);
					break;
				case R.id.checkBox2:
					DownloadManager.Request request2 = new DownloadManager.Request(
							Uri.parse(set_url(1)));
					request2.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[1])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[1] + ".mp3");
					downloadManager.enqueue(request2);
					break;
				case R.id.checkBox3:
					DownloadManager.Request request3 = new DownloadManager.Request(
							Uri.parse(set_url(2)));
					request3.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[2])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[2] + ".mp3");
					downloadManager.enqueue(request3);
					break;
				case R.id.checkBox4:
					DownloadManager.Request request4 = new DownloadManager.Request(
							Uri.parse(set_url(3)));
					request4.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[3])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[3] + ".mp3");
					downloadManager.enqueue(request4);
					break;
				case R.id.checkBox5:
					DownloadManager.Request request5 = new DownloadManager.Request(
							Uri.parse(set_url(4)));
					request5.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[4])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[4] + ".mp3");
					downloadManager.enqueue(request5);
					break;
				case R.id.checkBox6:
					DownloadManager.Request request6 = new DownloadManager.Request(
							Uri.parse(set_url(5)));
					request6.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[5])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[5] + ".mp3");
					downloadManager.enqueue(request6);
					break;
				case R.id.checkBox7:
					DownloadManager.Request request7 = new DownloadManager.Request(
							Uri.parse(set_url(6)));
					request7.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[6])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[6] + ".mp3");
					downloadManager.enqueue(request7);
					break;
				case R.id.checkBox8:

					DownloadManager.Request request8 = new DownloadManager.Request(
							Uri.parse(set_url(7)));
					request8.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[7])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[7] + ".mp3");
					downloadManager.enqueue(request8);
					break;
				case R.id.checkBox9:

					DownloadManager.Request request9 = new DownloadManager.Request(
							Uri.parse(set_url(8)));
					request9.setTitle(
							ifs2_name[current_reader] + "-" + ifs_name[8])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[8] + ".mp3");
					downloadManager.enqueue(request9);
					break;
				case R.id.checkBox10:

					DownloadManager.Request request10 = new DownloadManager.Request(
							Uri.parse(set_url(9)));
					request10
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[9])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[9] + ".mp3");
					downloadManager.enqueue(request10);
					break;
				case R.id.checkBox11:

					DownloadManager.Request request11 = new DownloadManager.Request(
							Uri.parse(set_url(10)));
					request11
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[10])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[10] + ".mp3");
					downloadManager.enqueue(request11);
					break;
				case R.id.checkBox12:

					DownloadManager.Request request12 = new DownloadManager.Request(
							Uri.parse(set_url(11)));
					request12
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[11])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[11] + ".mp3");
					downloadManager.enqueue(request12);
					break;
				case R.id.checkBox13:

					DownloadManager.Request request13 = new DownloadManager.Request(
							Uri.parse(set_url(12)));
					request13
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[12])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[12] + ".mp3");
					downloadManager.enqueue(request13);
					break;
				case R.id.checkBox14:

					DownloadManager.Request request14 = new DownloadManager.Request(
							Uri.parse(set_url(13)));
					request14
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[13])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[13] + ".mp3");
					downloadManager.enqueue(request14);
					break;
				case R.id.checkBox15:

					DownloadManager.Request request15 = new DownloadManager.Request(
							Uri.parse(set_url(14)));
					request15
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[14])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[14] + ".mp3");
					downloadManager.enqueue(request15);
					break;
				case R.id.checkBox16:

					DownloadManager.Request request16 = new DownloadManager.Request(
							Uri.parse(set_url(15)));
					request16
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[15])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[15] + ".mp3");
					downloadManager.enqueue(request16);
					break;
				case R.id.checkBox17:

					DownloadManager.Request request17 = new DownloadManager.Request(
							Uri.parse(set_url(16)));
					request17
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[16])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[16] + ".mp3");
					downloadManager.enqueue(request17);
					break;
				case R.id.checkBox18:

					DownloadManager.Request request18 = new DownloadManager.Request(
							Uri.parse(set_url(17)));
					request18
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[17])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[17] + ".mp3");
					downloadManager.enqueue(request18);
					break;
				case R.id.checkBox19:

					DownloadManager.Request request19 = new DownloadManager.Request(
							Uri.parse(set_url(18)));
					request19
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[18])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[18] + ".mp3");
					downloadManager.enqueue(request19);
					break;
				case R.id.checkBox20:

					DownloadManager.Request request20 = new DownloadManager.Request(
							Uri.parse(set_url(19)));
					request20
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[19])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[19] + ".mp3");
					downloadManager.enqueue(request20);
					break;
				case R.id.checkBox21:

					DownloadManager.Request request21 = new DownloadManager.Request(
							Uri.parse(set_url(20)));
					request21
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[20])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[20] + ".mp3");
					downloadManager.enqueue(request21);
					break;
				case R.id.checkBox22:

					DownloadManager.Request request22 = new DownloadManager.Request(
							Uri.parse(set_url(21)));
					request22
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[21])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[21] + ".mp3");
					downloadManager.enqueue(request22);
					break;
				case R.id.checkBox23:

					DownloadManager.Request request23 = new DownloadManager.Request(
							Uri.parse(set_url(22)));
					request23
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[22])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[22] + ".mp3");
					downloadManager.enqueue(request23);
					break;
				case R.id.checkBox24:

					DownloadManager.Request request24 = new DownloadManager.Request(
							Uri.parse(set_url(23)));
					request24
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[23])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[23] + ".mp3");
					downloadManager.enqueue(request24);
					break;
				case R.id.checkBox25:

					DownloadManager.Request request25 = new DownloadManager.Request(
							Uri.parse(set_url(24)));
					request25
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[24])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[24] + ".mp3");
					downloadManager.enqueue(request25);
					break;
				case R.id.checkBox26:

					DownloadManager.Request request26 = new DownloadManager.Request(
							Uri.parse(set_url(25)));
					request26
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[25])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[25] + ".mp3");
					downloadManager.enqueue(request26);
					break;
				case R.id.checkBox27:

					DownloadManager.Request request27 = new DownloadManager.Request(
							Uri.parse(set_url(26)));
					request27
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[26])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[26] + ".mp3");
					downloadManager.enqueue(request27);
					break;
				case R.id.checkBox28:

					DownloadManager.Request request28 = new DownloadManager.Request(
							Uri.parse(set_url(27)));
					request28
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[27])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[27] + ".mp3");
					downloadManager.enqueue(request28);
					break;
				case R.id.checkBox29:

					DownloadManager.Request request29 = new DownloadManager.Request(
							Uri.parse(set_url(28)));
					request29
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[28])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[28] + ".mp3");
					downloadManager.enqueue(request29);
					break;
				case R.id.checkBox30:

					DownloadManager.Request request30 = new DownloadManager.Request(
							Uri.parse(set_url(29)));
					request30
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[29])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[29] + ".mp3");
					downloadManager.enqueue(request30);
					break;
				case R.id.checkBox31:

					DownloadManager.Request request31 = new DownloadManager.Request(
							Uri.parse(set_url(30)));
					request31
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[30])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[30] + ".mp3");
					downloadManager.enqueue(request31);
					break;
				case R.id.checkBox32:

					DownloadManager.Request request32 = new DownloadManager.Request(
							Uri.parse(set_url(31)));
					request32
							.setTitle(
									ifs2_name[current_reader] + "-"
											+ ifs_name[31])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setMimeType("application/mp3")
							.setDescription(" Õ„Ì· «·„·›....")
							.setDestinationInExternalPublicDir(
									"/QuranKarem/Souar", ifs_name[31] + ".mp3");
					downloadManager.enqueue(request32);
					break;
				case R.id.checkBox33:

					DownloadManager.Request request33 = new DownloadManager.Request(
							Uri.parse(set_url(32)));
					request33
							.setTitle(ifs_name[32])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request33);
					break;
				case R.id.checkBox34:

					DownloadManager.Request request34 = new DownloadManager.Request(
							Uri.parse(set_url(33)));
					request34
							.setTitle(ifs_name[33])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request34);
					break;
				case R.id.checkBox35:

					DownloadManager.Request request35 = new DownloadManager.Request(
							Uri.parse(set_url(34)));
					request35
							.setTitle(ifs_name[34])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request35);
					break;
				case R.id.checkBox36:

					DownloadManager.Request request36 = new DownloadManager.Request(
							Uri.parse(set_url(35)));
					request36
							.setTitle(ifs_name[35])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request36);
					break;
				case R.id.checkBox37:

					DownloadManager.Request request37 = new DownloadManager.Request(
							Uri.parse(set_url(36)));
					request37
							.setTitle(ifs_name[36])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request37);
					break;
				case R.id.checkBox38:

					DownloadManager.Request request38 = new DownloadManager.Request(
							Uri.parse(set_url(37)));
					request38
							.setTitle(ifs_name[37])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request38);
					break;
				case R.id.checkBox39:

					DownloadManager.Request request39 = new DownloadManager.Request(
							Uri.parse(set_url(38)));
					request39
							.setTitle(ifs_name[38])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request39);
					break;
				case R.id.checkBox40:

					DownloadManager.Request request40 = new DownloadManager.Request(
							Uri.parse(set_url(39)));
					request40
							.setTitle(ifs_name[39])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request40);
					break;
				case R.id.checkBox41:

					DownloadManager.Request request41 = new DownloadManager.Request(
							Uri.parse(set_url(40)));
					request41
							.setTitle(ifs_name[40])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request41);
					break;
				case R.id.checkBox42:

					DownloadManager.Request request42 = new DownloadManager.Request(
							Uri.parse(set_url(41)));
					request42
							.setTitle(ifs_name[41])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request42);
					break;
				case R.id.checkBox43:

					DownloadManager.Request request43 = new DownloadManager.Request(
							Uri.parse(set_url(42)));
					request43
							.setTitle(ifs_name[42])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request43);
					break;
				case R.id.checkBox44:

					DownloadManager.Request request44 = new DownloadManager.Request(
							Uri.parse(set_url(43)));
					request44
							.setTitle(ifs_name[43])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request44);
					break;
				case R.id.checkBox45:

					DownloadManager.Request request45 = new DownloadManager.Request(
							Uri.parse(set_url(44)));
					request45
							.setTitle(ifs_name[44])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request45);
					break;
				case R.id.checkBox46:

					DownloadManager.Request request46 = new DownloadManager.Request(
							Uri.parse(set_url(45)));
					request46
							.setTitle(ifs_name[45])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request46);
					break;
				case R.id.checkBox47:

					DownloadManager.Request request47 = new DownloadManager.Request(
							Uri.parse(set_url(46)));
					request47
							.setTitle(ifs_name[46])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request47);
					break;
				case R.id.checkBox48:

					DownloadManager.Request request48 = new DownloadManager.Request(
							Uri.parse(set_url(47)));
					request48
							.setTitle(ifs_name[47])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request48);
					break;
				case R.id.checkBox49:

					DownloadManager.Request request49 = new DownloadManager.Request(
							Uri.parse(set_url(48)));
					request49
							.setTitle(ifs_name[48])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request49);
					break;
				case R.id.checkBox50:

					DownloadManager.Request request50 = new DownloadManager.Request(
							Uri.parse(set_url(49)));
					request50
							.setTitle(ifs_name[49])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request50);
					break;
				case R.id.checkBox51:

					DownloadManager.Request request51 = new DownloadManager.Request(
							Uri.parse(set_url(50)));
					request51
							.setTitle(ifs_name[50])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request51);
					break;
				case R.id.checkBox52:

					DownloadManager.Request request52 = new DownloadManager.Request(
							Uri.parse(set_url(51)));
					request52
							.setTitle(ifs_name[51])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request52);
					break;
				case R.id.checkBox53:

					DownloadManager.Request request53 = new DownloadManager.Request(
							Uri.parse(set_url(52)));
					request53
							.setTitle(ifs_name[52])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request53);
					break;
				case R.id.checkBox54:

					DownloadManager.Request request54 = new DownloadManager.Request(
							Uri.parse(set_url(53)));
					request54
							.setTitle(ifs_name[53])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request54);
					break;
				case R.id.checkBox55:

					DownloadManager.Request request55 = new DownloadManager.Request(
							Uri.parse(set_url(54)));
					request55
							.setTitle(ifs_name[54])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request55);
					break;
				case R.id.checkBox56:

					DownloadManager.Request request56 = new DownloadManager.Request(
							Uri.parse(set_url(55)));
					request56
							.setTitle(ifs_name[55])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request56);
					break;
				case R.id.checkBox57:

					DownloadManager.Request request57 = new DownloadManager.Request(
							Uri.parse(set_url(56)));
					request57
							.setTitle(ifs_name[56])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request57);
					break;
				case R.id.checkBox58:

					DownloadManager.Request request58 = new DownloadManager.Request(
							Uri.parse(set_url(57)));
					request58
							.setTitle(ifs_name[57])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request58);
					break;
				case R.id.checkBox59:

					DownloadManager.Request request59 = new DownloadManager.Request(
							Uri.parse(set_url(58)));
					request59
							.setTitle(ifs_name[58])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request59);
					break;
				case R.id.checkBox60:

					DownloadManager.Request request60 = new DownloadManager.Request(
							Uri.parse(set_url(59)));
					request60
							.setTitle(ifs_name[59])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request60);
					break;
				case R.id.checkBox61:

					DownloadManager.Request request61 = new DownloadManager.Request(
							Uri.parse(set_url(60)));
					request61
							.setTitle(ifs_name[60])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request61);
					break;
				case R.id.checkBox62:

					DownloadManager.Request request62 = new DownloadManager.Request(
							Uri.parse(set_url(61)));
					request62
							.setTitle(ifs_name[61])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request62);
					break;
				case R.id.checkBox63:

					DownloadManager.Request request63 = new DownloadManager.Request(
							Uri.parse(set_url(62)));
					request63
							.setTitle(ifs_name[62])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request63);
					break;
				case R.id.checkBox64:

					DownloadManager.Request request64 = new DownloadManager.Request(
							Uri.parse(set_url(63)));
					request64
							.setTitle(ifs_name[63])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request64);
					break;
				case R.id.checkBox65:

					DownloadManager.Request request65 = new DownloadManager.Request(
							Uri.parse(set_url(64)));
					request65
							.setTitle(ifs_name[64])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request65);
					break;
				case R.id.checkBox66:

					DownloadManager.Request request66 = new DownloadManager.Request(
							Uri.parse(set_url(65)));
					request66
							.setTitle(ifs_name[65])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request66);
					break;
				case R.id.checkBox67:

					DownloadManager.Request request67 = new DownloadManager.Request(
							Uri.parse(set_url(66)));
					request67
							.setTitle(ifs_name[66])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request67);
					break;
				case R.id.checkBox68:

					DownloadManager.Request request68 = new DownloadManager.Request(
							Uri.parse(set_url(67)));
					request68
							.setTitle(ifs_name[67])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request68);
					break;
				case R.id.checkBox69:

					DownloadManager.Request request69 = new DownloadManager.Request(
							Uri.parse(set_url(68)));
					request69
							.setTitle(ifs_name[68])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request69);
					break;
				case R.id.checkBox70:

					DownloadManager.Request request70 = new DownloadManager.Request(
							Uri.parse(set_url(69)));
					request70
							.setTitle(ifs_name[69])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request70);
					break;
				case R.id.checkBox71:

					DownloadManager.Request request71 = new DownloadManager.Request(
							Uri.parse(set_url(70)));
					request71
							.setTitle(ifs_name[70])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request71);
					break;
				case R.id.checkBox72:

					DownloadManager.Request request72 = new DownloadManager.Request(
							Uri.parse(set_url(71)));
					request72
							.setTitle(ifs_name[71])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request72);
					break;
				case R.id.checkBox73:

					DownloadManager.Request request73 = new DownloadManager.Request(
							Uri.parse(set_url(72)));
					request73
							.setTitle(ifs_name[72])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request73);
					break;
				case R.id.checkBox74:

					DownloadManager.Request request74 = new DownloadManager.Request(
							Uri.parse(set_url(73)));
					request74
							.setTitle(ifs_name[73])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request74);
					break;
				case R.id.checkBox75:

					DownloadManager.Request request75 = new DownloadManager.Request(
							Uri.parse(set_url(74)));
					request75
							.setTitle(ifs_name[74])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request75);
					break;
				case R.id.checkBox76:

					DownloadManager.Request request76 = new DownloadManager.Request(
							Uri.parse(set_url(75)));
					request76
							.setTitle(ifs_name[75])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request76);
					break;
				case R.id.checkBox77:

					DownloadManager.Request request77 = new DownloadManager.Request(
							Uri.parse(set_url(76)));
					request77
							.setTitle(ifs_name[76])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request77);
					break;
				case R.id.checkBox78:

					DownloadManager.Request request78 = new DownloadManager.Request(
							Uri.parse(set_url(77)));
					request78
							.setTitle(ifs_name[77])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request78);
					break;
				case R.id.checkBox79:

					DownloadManager.Request request79 = new DownloadManager.Request(
							Uri.parse(set_url(78)));
					request79
							.setTitle(ifs_name[78])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request79);
					break;
				case R.id.checkBox80:

					DownloadManager.Request request80 = new DownloadManager.Request(
							Uri.parse(set_url(79)));
					request80
							.setTitle(ifs_name[79])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request80);
					break;
				case R.id.checkBox81:

					DownloadManager.Request request81 = new DownloadManager.Request(
							Uri.parse(set_url(80)));
					request81
							.setTitle(ifs_name[80])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request81);
					break;
				case R.id.checkBox82:

					DownloadManager.Request request82 = new DownloadManager.Request(
							Uri.parse(set_url(81)));
					request82
							.setTitle(ifs_name[81])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request82);
					break;
				case R.id.checkBox83:

					DownloadManager.Request request83 = new DownloadManager.Request(
							Uri.parse(set_url(82)));
					request83
							.setTitle(ifs_name[82])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request83);
					break;
				case R.id.checkBox84:

					DownloadManager.Request request84 = new DownloadManager.Request(
							Uri.parse(set_url(83)));
					request84
							.setTitle(ifs_name[83])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request84);
					break;
				case R.id.checkBox85:

					DownloadManager.Request request85 = new DownloadManager.Request(
							Uri.parse(set_url(84)));
					request85
							.setTitle(ifs_name[84])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request85);
					break;
				case R.id.checkBox86:

					DownloadManager.Request request86 = new DownloadManager.Request(
							Uri.parse(set_url(85)));
					request86
							.setTitle(ifs_name[85])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request86);
					break;
				case R.id.checkBox87:

					DownloadManager.Request request87 = new DownloadManager.Request(
							Uri.parse(set_url(86)));
					request87
							.setTitle(ifs_name[86])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request87);
					break;
				case R.id.checkBox88:

					DownloadManager.Request request88 = new DownloadManager.Request(
							Uri.parse(set_url(87)));
					request88
							.setTitle(ifs_name[87])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request88);
					break;
				case R.id.checkBox89:

					DownloadManager.Request request89 = new DownloadManager.Request(
							Uri.parse(set_url(88)));
					request89
							.setTitle(ifs_name[88])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request89);
					break;
				case R.id.checkBox90:

					DownloadManager.Request request90 = new DownloadManager.Request(
							Uri.parse(set_url(89)));
					request90
							.setTitle(ifs_name[89])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request90);
					break;
				case R.id.checkBox91:

					DownloadManager.Request request91 = new DownloadManager.Request(
							Uri.parse(set_url(90)));
					request91
							.setTitle(ifs_name[90])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request91);
					break;
				case R.id.checkBox92:

					DownloadManager.Request request92 = new DownloadManager.Request(
							Uri.parse(set_url(91)));
					request92
							.setTitle(ifs_name[91])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request92);
					break;
				case R.id.checkBox93:

					DownloadManager.Request request93 = new DownloadManager.Request(
							Uri.parse(set_url(92)));
					request93
							.setTitle(ifs_name[92])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request93);
					break;
				case R.id.checkBox94:

					DownloadManager.Request request94 = new DownloadManager.Request(
							Uri.parse(set_url(93)));
					request94
							.setTitle(ifs_name[93])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request94);
					break;
				case R.id.checkBox95:

					DownloadManager.Request request95 = new DownloadManager.Request(
							Uri.parse(set_url(94)));
					request95
							.setTitle(ifs_name[94])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request95);
					break;
				case R.id.checkBox96:

					DownloadManager.Request request96 = new DownloadManager.Request(
							Uri.parse(set_url(95)));
					request96
							.setTitle(ifs_name[95])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request96);
					break;
				case R.id.checkBox97:

					DownloadManager.Request request97 = new DownloadManager.Request(
							Uri.parse(set_url(96)));
					request97
							.setTitle(ifs_name[96])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request97);
					break;
				case R.id.checkBox98:

					DownloadManager.Request request98 = new DownloadManager.Request(
							Uri.parse(set_url(97)));
					request98
							.setTitle(ifs_name[97])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request98);
					break;
				case R.id.checkBox99:

					DownloadManager.Request request99 = new DownloadManager.Request(
							Uri.parse(set_url(98)));
					request99
							.setTitle(ifs_name[98])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request99);
					break;
				case R.id.checkBox100:

					DownloadManager.Request request100 = new DownloadManager.Request(
							Uri.parse(set_url(99)));
					request100
							.setTitle(ifs_name[99])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request100);
					break;
				case R.id.checkBox101:

					DownloadManager.Request request101 = new DownloadManager.Request(
							Uri.parse(set_url(100)));
					request101
							.setTitle(ifs_name[100])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request101);
					break;
				case R.id.checkBox102:

					DownloadManager.Request request102 = new DownloadManager.Request(
							Uri.parse(set_url(101)));
					request102
							.setTitle(ifs_name[101])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request102);
					break;
				case R.id.checkBox103:

					DownloadManager.Request request103 = new DownloadManager.Request(
							Uri.parse(set_url(102)));
					request103
							.setTitle(ifs_name[102])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request103);
					break;
				case R.id.checkBox104:

					DownloadManager.Request request104 = new DownloadManager.Request(
							Uri.parse(set_url(103)));
					request104
							.setTitle(ifs_name[103])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request104);
					break;
				case R.id.checkBox105:

					DownloadManager.Request request105 = new DownloadManager.Request(
							Uri.parse(set_url(104)));
					request105
							.setTitle(ifs_name[104])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request105);
					break;
				case R.id.checkBox106:

					DownloadManager.Request request106 = new DownloadManager.Request(
							Uri.parse(set_url(105)));
					request106
							.setTitle(ifs_name[105])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request106);
					break;
				case R.id.checkBox107:

					DownloadManager.Request request107 = new DownloadManager.Request(
							Uri.parse(set_url(106)));
					request107
							.setTitle(ifs_name[106])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request107);
					break;
				case R.id.checkBox108:

					DownloadManager.Request request108 = new DownloadManager.Request(
							Uri.parse(set_url(107)));
					request108
							.setTitle(ifs_name[107])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request108);
					break;
				case R.id.checkBox109:

					DownloadManager.Request request109 = new DownloadManager.Request(
							Uri.parse(set_url(108)));
					request109
							.setTitle(ifs_name[108])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request109);
					break;
				case R.id.checkBox110:

					DownloadManager.Request request110 = new DownloadManager.Request(
							Uri.parse(set_url(109)));
					request110
							.setTitle(ifs_name[109])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request110);
					buttonView.setClickable(false);
					break;
				case R.id.checkBox111:

					DownloadManager.Request request111 = new DownloadManager.Request(
							Uri.parse(set_url(110)));
					request111
							.setTitle(ifs_name[110])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request111);
					break;
				case R.id.checkBox112:

					DownloadManager.Request request112 = new DownloadManager.Request(
							Uri.parse(set_url(111)));
					request112
							.setTitle(ifs_name[111])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request112);
					break;
				case R.id.checkBox113:

					DownloadManager.Request request113 = new DownloadManager.Request(
							Uri.parse(set_url(112)));
					request113
							.setTitle(ifs_name[112])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request113);
					break;
				case R.id.checkBox114:

					DownloadManager.Request request114 = new DownloadManager.Request(
							Uri.parse(set_url(113)));
					request114
							.setTitle(ifs_name[113])
							.setAllowedNetworkTypes(
									DownloadManager.Request.NETWORK_WIFI
											| DownloadManager.Request.NETWORK_MOBILE)
							.setDescription(" Õ„Ì· «·„·›....")
							.setNotificationVisibility(
									DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
					downloadManager.enqueue(request114);
					break;
				case R.id.select_all:
					a1.setChecked(true);
					a2.setChecked(true);
					a3.setChecked(true);
					a4.setChecked(true);
					a5.setChecked(true);
					a6.setChecked(true);
					a7.setChecked(true);
					a8.setChecked(true);
					a9.setChecked(true);
					a10.setChecked(true);
					a11.setChecked(true);
					a12.setChecked(true);
					a13.setChecked(true);
					a14.setChecked(true);
					a15.setChecked(true);
					a16.setChecked(true);
					a17.setChecked(true);
					a18.setChecked(true);
					a19.setChecked(true);
					a20.setChecked(true);
					a21.setChecked(true);
					a22.setChecked(true);
					a23.setChecked(true);
					a24.setChecked(true);
					a25.setChecked(true);
					a26.setChecked(true);
					a27.setChecked(true);
					a28.setChecked(true);
					a29.setChecked(true);
					a30.setChecked(true);
					a31.setChecked(true);
					a32.setChecked(true);
					a33.setChecked(true);
					a34.setChecked(true);
					a35.setChecked(true);
					a36.setChecked(true);
					a37.setChecked(true);
					a38.setChecked(true);
					a39.setChecked(true);
					a40.setChecked(true);
					a41.setChecked(true);
					a42.setChecked(true);
					a43.setChecked(true);
					a44.setChecked(true);
					a45.setChecked(true);
					a46.setChecked(true);
					a47.setChecked(true);
					a48.setChecked(true);
					a49.setChecked(true);
					a50.setChecked(true);
					a51.setChecked(true);
					a52.setChecked(true);
					a53.setChecked(true);
					a54.setChecked(true);
					a55.setChecked(true);
					a56.setChecked(true);
					a57.setChecked(true);
					a58.setChecked(true);
					a59.setChecked(true);
					a60.setChecked(true);
					a61.setChecked(true);
					a62.setChecked(true);
					a63.setChecked(true);
					a64.setChecked(true);
					a65.setChecked(true);
					a66.setChecked(true);
					a67.setChecked(true);
					a68.setChecked(true);
					a69.setChecked(true);
					a70.setChecked(true);
					a71.setChecked(true);
					a72.setChecked(true);
					a73.setChecked(true);
					a74.setChecked(true);
					a75.setChecked(true);
					a76.setChecked(true);
					a77.setChecked(true);
					a78.setChecked(true);
					a79.setChecked(true);
					a80.setChecked(true);
					a81.setChecked(true);
					a82.setChecked(true);
					a83.setChecked(true);
					a84.setChecked(true);
					a85.setChecked(true);
					a86.setChecked(true);
					a87.setChecked(true);
					a88.setChecked(true);
					a89.setChecked(true);
					a90.setChecked(true);
					a91.setChecked(true);
					a92.setChecked(true);
					a93.setChecked(true);
					a94.setChecked(true);
					a95.setChecked(true);
					a96.setChecked(true);
					a97.setChecked(true);
					a98.setChecked(true);
					a99.setChecked(true);
					a100.setChecked(true);
					a101.setChecked(true);
					a102.setChecked(true);
					a103.setChecked(true);
					a104.setChecked(true);
					a105.setChecked(true);
					a106.setChecked(true);
					a107.setChecked(true);
					a108.setChecked(true);
					a109.setChecked(true);
					a110.setChecked(true);
					a111.setChecked(true);
					a112.setChecked(true);
					a113.setChecked(true);
					a114.setChecked(true);
					download_file(0);
					break;
				}
			}
		} else {
			AlertDialog ad = new AlertDialog.Builder(this).create();
			ad.setTitle("<<«·‘»ﬂ… ·«  ⁄„·>>");
			ad.setMessage("Ì—ÃÏ «· √ﬂœ „‰ √‰ﬂ „ ’· »«·√‰ —‰  ÊÕ«Ê· ·«Õﬁ«");
			ad.setButton("„Ê«›ﬁ", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub

				}
			});
			ad.setIcon(R.drawable.closepng);
			ad.show();

		}
	}

	private void is_online_1() {
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
				.isConnectedOrConnecting()
				|| cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
						.isConnectedOrConnecting()) {
			isOnline = true;
		} else {
			isOnline = false;
		}

	}

	private String getReaderFolder() {
		String c_r = "";
		switch (current_reader) {
		case 0:
			c_r = "saad-el-ghamidi";
			break;
		case 1:
			c_r = "abdel-basset";
			break;
		case 2:
			c_r = "mishary-rashid-alafasy";
			break;
		case 3:
			c_r = "saud-shuraim";
			break;
		case 4:
			c_r = "mahmoud-khalil-al-hussary";
			break;
		case 5:
			c_r = "mohamed-seddik-el-menchaoui";
			break;
		case 6:
			c_r = "ali-jaber";
			break;
		case 7:
			c_r = "ali-al-hodhaifi";
			break;
		}
		return c_r;
	}

	private void download_file(int s_n) {
		s_n = current_name;
		DownloadManager.Request request_all = new DownloadManager.Request(
				Uri.parse(set_url(s_n)));
		request_all
				.setTitle(ifs_name[s_n])
				.setAllowedNetworkTypes(
						DownloadManager.Request.NETWORK_WIFI
								| DownloadManager.Request.NETWORK_MOBILE)
				.setAllowedOverRoaming(false)
				.setDescription(" Õ„Ì· «·„·›....")
				.setNotificationVisibility(
						DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
		downloadManager.enqueue(request_all);
	}

	private String set_url(int s_n) {
		String url = null;
		Url = new URL();
		Url.setReader(current_reader);
		if (s_n == 0) {
			url = Url.b1();
		} else if (s_n == 1) {
			url = Url.b2();
		} else if (s_n == 2) {
			url = Url.b3();
		} else if (s_n == 3) {
			url = Url.b4();
		} else if (s_n == 4) {
			url = Url.b5();
		} else if (s_n == 5) {
			url = Url.b6();
		} else if (s_n == 6) {
			url = Url.b7();
		} else if (s_n == 7) {
			url = Url.b8();
		} else if (s_n == 8) {
			url = Url.b9();
		} else if (s_n == 9) {
			url = Url.b10();
		} else if (s_n == 10) {
			url = Url.b11();
		} else if (s_n == 11) {
			url = Url.b12();
		} else if (s_n == 12) {
			url = Url.b13();
		} else if (s_n == 13) {
			url = Url.b14();
		} else if (s_n == 14) {
			url = Url.b15();
		} else if (s_n == 15) {
			url = Url.b16();
		} else if (s_n == 16) {
			url = Url.b17();
		} else if (s_n == 17) {
			url = Url.b18();
		} else if (s_n == 18) {
			url = Url.b19();
		} else if (s_n == 19) {
			url = Url.b20();
		} else if (s_n == 20) {
			url = Url.b21();
		} else if (s_n == 21) {
			url = Url.b22();
		} else if (s_n == 22) {
			url = Url.b23();
		} else if (s_n == 23) {
			url = Url.b24();
		} else if (s_n == 24) {
			url = Url.b25();
		} else if (s_n == 25) {
			url = Url.b26();
		} else if (s_n == 26) {
			url = Url.b27();
		} else if (s_n == 27) {
			url = Url.b28();
		} else if (s_n == 28) {
			url = Url.b29();
		} else if (s_n == 29) {
			url = Url.b30();
		} else if (s_n == 30) {
			url = Url.b31();
		} else if (s_n == 31) {
			url = Url.b32();
		} else if (s_n == 32) {
			url = Url.b33();
		} else if (s_n == 33) {
			url = Url.b34();
		} else if (s_n == 34) {
			url = Url.b35();
		} else if (s_n == 35) {
			url = Url.b36();
		} else if (s_n == 36) {
			url = Url.b37();
		} else if (s_n == 37) {
			url = Url.b38();
		} else if (s_n == 38) {
			url = Url.b39();
		} else if (s_n == 39) {
			url = Url.b40();
		} else if (s_n == 40) {
			url = Url.b41();
		} else if (s_n == 41) {
			url = Url.b42();
		} else if (s_n == 42) {
			url = Url.b43();
		} else if (s_n == 43) {
			url = Url.b44();
		} else if (s_n == 44) {
			url = Url.b45();
		} else if (s_n == 45) {
			url = Url.b46();
		} else if (s_n == 46) {
			url = Url.b47();
		} else if (s_n == 47) {
			url = Url.b48();
		} else if (s_n == 48) {
			url = Url.b49();
		} else if (s_n == 49) {
			url = Url.b50();
		} else if (s_n == 50) {
			url = Url.b51();
		} else if (s_n == 51) {
			url = Url.b52();
		} else if (s_n == 52) {
			url = Url.b53();
		} else if (s_n == 53) {
			url = Url.b54();
		} else if (s_n == 54) {
			url = Url.b55();
		} else if (s_n == 55) {
			url = Url.b56();
		} else if (s_n == 56) {
			url = Url.b57();
		} else if (s_n == 57) {
			url = Url.b58();
		} else if (s_n == 58) {
			url = Url.b59();
		} else if (s_n == 59) {
			url = Url.b60();
		} else if (s_n == 60) {
			url = Url.b61();
		} else if (s_n == 61) {
			url = Url.b62();
		} else if (s_n == 62) {
			url = Url.b63();
		} else if (s_n == 63) {
			url = Url.b64();
		} else if (s_n == 64) {
			url = Url.b65();
		} else if (s_n == 65) {
			url = Url.b66();
		} else if (s_n == 66) {
			url = Url.b67();
		} else if (s_n == 67) {
			url = Url.b68();
		} else if (s_n == 68) {
			url = Url.b69();
		} else if (s_n == 69) {
			url = Url.b70();
		} else if (s_n == 70) {
			url = Url.b71();
		} else if (s_n == 71) {
			url = Url.b72();
		} else if (s_n == 72) {
			url = Url.b73();
		} else if (s_n == 73) {
			url = Url.b74();
		} else if (s_n == 74) {
			url = Url.b75();
		} else if (s_n == 75) {
			url = Url.b76();
		} else if (s_n == 76) {
			url = Url.b77();
		} else if (s_n == 77) {
			url = Url.b78();
		} else if (s_n == 78) {
			url = Url.b79();
		} else if (s_n == 79) {
			url = Url.b80();
		} else if (s_n == 80) {
			url = Url.b81();
		} else if (s_n == 81) {
			url = Url.b82();
		} else if (s_n == 82) {
			url = Url.b83();
		} else if (s_n == 83) {
			url = Url.b84();
		} else if (s_n == 84) {
			url = Url.b85();
		} else if (s_n == 85) {
			url = Url.b86();
		} else if (s_n == 86) {
			url = Url.b87();
		} else if (s_n == 87) {
			url = Url.b88();
		} else if (s_n == 88) {
			url = Url.b89();
		} else if (s_n == 89) {
			url = Url.b90();
		} else if (s_n == 90) {
			url = Url.b91();
		} else if (s_n == 91) {
			url = Url.b92();
		} else if (s_n == 92) {
			url = Url.b93();
		} else if (s_n == 93) {
			url = Url.b94();
		} else if (s_n == 94) {
			url = Url.b95();
		} else if (s_n == 95) {
			url = Url.b96();
		} else if (s_n == 96) {
			url = Url.b97();
		} else if (s_n == 97) {
			url = Url.b98();
		} else if (s_n == 98) {
			url = Url.b99();
		} else if (s_n == 99) {
			url = Url.b100();
		} else if (s_n == 100) {
			url = Url.b101();
		} else if (s_n == 101) {
			url = Url.b102();
		} else if (s_n == 102) {
			url = Url.b103();
		} else if (s_n == 103) {
			url = Url.b104();
		} else if (s_n == 104) {
			url = Url.b105();
		} else if (s_n == 105) {
			url = Url.b106();
		} else if (s_n == 106) {
			url = Url.b107();
		} else if (s_n == 107) {
			url = Url.b108();
		} else if (s_n == 108) {
			url = Url.b109();
		} else if (s_n == 109) {
			url = Url.b110();
		} else if (s_n == 110) {
			url = Url.b111();
		} else if (s_n == 111) {
			url = Url.b112();
		} else if (s_n == 112) {
			url = Url.b113();
		} else if (s_n == 113) {
			url = Url.b114();
		}

		return url;
	}

	private void init() {
		// TODO Auto-generated method stub
		downloadManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
		a1 = (CheckBox) findViewById(R.id.checkBox1);
		a1.setOnCheckedChangeListener(this);
		a2 = (CheckBox) findViewById(R.id.checkBox2);
		a2.setOnCheckedChangeListener(this);
		a3 = (CheckBox) findViewById(R.id.checkBox3);
		a3.setOnCheckedChangeListener(this);
		a4 = (CheckBox) findViewById(R.id.checkBox4);
		a4.setOnCheckedChangeListener(this);
		a5 = (CheckBox) findViewById(R.id.checkBox5);
		a5.setOnCheckedChangeListener(this);
		a6 = (CheckBox) findViewById(R.id.checkBox6);
		a6.setOnCheckedChangeListener(this);
		a7 = (CheckBox) findViewById(R.id.checkBox7);
		a7.setOnCheckedChangeListener(this);
		a8 = (CheckBox) findViewById(R.id.checkBox8);
		a8.setOnCheckedChangeListener(this);
		a9 = (CheckBox) findViewById(R.id.checkBox9);
		a9.setOnCheckedChangeListener(this);
		a10 = (CheckBox) findViewById(R.id.checkBox10);
		a10.setOnCheckedChangeListener(this);
		a11 = (CheckBox) findViewById(R.id.checkBox11);
		a11.setOnCheckedChangeListener(this);
		a12 = (CheckBox) findViewById(R.id.checkBox12);
		a12.setOnCheckedChangeListener(this);
		a13 = (CheckBox) findViewById(R.id.checkBox13);
		a13.setOnCheckedChangeListener(this);
		a14 = (CheckBox) findViewById(R.id.checkBox14);
		a14.setOnCheckedChangeListener(this);
		a15 = (CheckBox) findViewById(R.id.checkBox15);
		a15.setOnCheckedChangeListener(this);
		a16 = (CheckBox) findViewById(R.id.checkBox16);
		a16.setOnCheckedChangeListener(this);
		a17 = (CheckBox) findViewById(R.id.checkBox17);
		a17.setOnCheckedChangeListener(this);
		a18 = (CheckBox) findViewById(R.id.checkBox18);
		a18.setOnCheckedChangeListener(this);
		a19 = (CheckBox) findViewById(R.id.checkBox19);
		a19.setOnCheckedChangeListener(this);
		a20 = (CheckBox) findViewById(R.id.checkBox20);
		a20.setOnCheckedChangeListener(this);
		a21 = (CheckBox) findViewById(R.id.checkBox21);
		a21.setOnCheckedChangeListener(this);
		a22 = (CheckBox) findViewById(R.id.checkBox22);
		a22.setOnCheckedChangeListener(this);
		a23 = (CheckBox) findViewById(R.id.checkBox23);
		a23.setOnCheckedChangeListener(this);
		a24 = (CheckBox) findViewById(R.id.checkBox24);
		a24.setOnCheckedChangeListener(this);
		a25 = (CheckBox) findViewById(R.id.checkBox25);
		a25.setOnCheckedChangeListener(this);
		a26 = (CheckBox) findViewById(R.id.checkBox26);
		a26.setOnCheckedChangeListener(this);
		a27 = (CheckBox) findViewById(R.id.checkBox27);
		a27.setOnCheckedChangeListener(this);
		a28 = (CheckBox) findViewById(R.id.checkBox28);
		a28.setOnCheckedChangeListener(this);
		a29 = (CheckBox) findViewById(R.id.checkBox29);
		a29.setOnCheckedChangeListener(this);
		a30 = (CheckBox) findViewById(R.id.checkBox30);
		a30.setOnCheckedChangeListener(this);
		a31 = (CheckBox) findViewById(R.id.checkBox31);
		a31.setOnCheckedChangeListener(this);
		a32 = (CheckBox) findViewById(R.id.checkBox32);
		a32.setOnCheckedChangeListener(this);
		a33 = (CheckBox) findViewById(R.id.checkBox33);
		a33.setOnCheckedChangeListener(this);
		a34 = (CheckBox) findViewById(R.id.checkBox34);
		a34.setOnCheckedChangeListener(this);
		a35 = (CheckBox) findViewById(R.id.checkBox35);
		a35.setOnCheckedChangeListener(this);
		a36 = (CheckBox) findViewById(R.id.checkBox36);
		a36.setOnCheckedChangeListener(this);
		a37 = (CheckBox) findViewById(R.id.checkBox37);
		a37.setOnCheckedChangeListener(this);
		a38 = (CheckBox) findViewById(R.id.checkBox38);
		a38.setOnCheckedChangeListener(this);
		a39 = (CheckBox) findViewById(R.id.checkBox39);
		a39.setOnCheckedChangeListener(this);
		a40 = (CheckBox) findViewById(R.id.checkBox40);
		a40.setOnCheckedChangeListener(this);
		a41 = (CheckBox) findViewById(R.id.checkBox41);
		a41.setOnCheckedChangeListener(this);
		a42 = (CheckBox) findViewById(R.id.checkBox42);
		a42.setOnCheckedChangeListener(this);
		a43 = (CheckBox) findViewById(R.id.checkBox43);
		a43.setOnCheckedChangeListener(this);
		a44 = (CheckBox) findViewById(R.id.checkBox44);
		a44.setOnCheckedChangeListener(this);
		a45 = (CheckBox) findViewById(R.id.checkBox45);
		a45.setOnCheckedChangeListener(this);
		a46 = (CheckBox) findViewById(R.id.checkBox46);
		a46.setOnCheckedChangeListener(this);
		a47 = (CheckBox) findViewById(R.id.checkBox47);
		a47.setOnCheckedChangeListener(this);
		a48 = (CheckBox) findViewById(R.id.checkBox48);
		a48.setOnCheckedChangeListener(this);
		a49 = (CheckBox) findViewById(R.id.checkBox49);
		a49.setOnCheckedChangeListener(this);
		a50 = (CheckBox) findViewById(R.id.checkBox50);
		a50.setOnCheckedChangeListener(this);
		a51 = (CheckBox) findViewById(R.id.checkBox51);
		a51.setOnCheckedChangeListener(this);
		a52 = (CheckBox) findViewById(R.id.checkBox52);
		a52.setOnCheckedChangeListener(this);
		a53 = (CheckBox) findViewById(R.id.checkBox53);
		a53.setOnCheckedChangeListener(this);
		a54 = (CheckBox) findViewById(R.id.checkBox54);
		a54.setOnCheckedChangeListener(this);
		a55 = (CheckBox) findViewById(R.id.checkBox55);
		a55.setOnCheckedChangeListener(this);
		a56 = (CheckBox) findViewById(R.id.checkBox56);
		a56.setOnCheckedChangeListener(this);
		a57 = (CheckBox) findViewById(R.id.checkBox57);
		a57.setOnCheckedChangeListener(this);
		a58 = (CheckBox) findViewById(R.id.checkBox58);
		a58.setOnCheckedChangeListener(this);
		a59 = (CheckBox) findViewById(R.id.checkBox59);
		a59.setOnCheckedChangeListener(this);
		a60 = (CheckBox) findViewById(R.id.checkBox60);
		a60.setOnCheckedChangeListener(this);
		a61 = (CheckBox) findViewById(R.id.checkBox61);
		a61.setOnCheckedChangeListener(this);
		a62 = (CheckBox) findViewById(R.id.checkBox62);
		a62.setOnCheckedChangeListener(this);
		a63 = (CheckBox) findViewById(R.id.checkBox63);
		a63.setOnCheckedChangeListener(this);
		a64 = (CheckBox) findViewById(R.id.checkBox64);
		a64.setOnCheckedChangeListener(this);
		a65 = (CheckBox) findViewById(R.id.checkBox65);
		a65.setOnCheckedChangeListener(this);
		a66 = (CheckBox) findViewById(R.id.checkBox66);
		a66.setOnCheckedChangeListener(this);
		a67 = (CheckBox) findViewById(R.id.checkBox67);
		a67.setOnCheckedChangeListener(this);
		a68 = (CheckBox) findViewById(R.id.checkBox68);
		a68.setOnCheckedChangeListener(this);
		a69 = (CheckBox) findViewById(R.id.checkBox69);
		a69.setOnCheckedChangeListener(this);
		a70 = (CheckBox) findViewById(R.id.checkBox70);
		a70.setOnCheckedChangeListener(this);
		a71 = (CheckBox) findViewById(R.id.checkBox71);
		a71.setOnCheckedChangeListener(this);
		a72 = (CheckBox) findViewById(R.id.checkBox72);
		a72.setOnCheckedChangeListener(this);
		a73 = (CheckBox) findViewById(R.id.checkBox73);
		a73.setOnCheckedChangeListener(this);
		a74 = (CheckBox) findViewById(R.id.checkBox74);
		a74.setOnCheckedChangeListener(this);
		a75 = (CheckBox) findViewById(R.id.checkBox75);
		a75.setOnCheckedChangeListener(this);
		a76 = (CheckBox) findViewById(R.id.checkBox76);
		a76.setOnCheckedChangeListener(this);
		a77 = (CheckBox) findViewById(R.id.checkBox77);
		a77.setOnCheckedChangeListener(this);
		a78 = (CheckBox) findViewById(R.id.checkBox78);
		a78.setOnCheckedChangeListener(this);
		a79 = (CheckBox) findViewById(R.id.checkBox79);
		a79.setOnCheckedChangeListener(this);
		a80 = (CheckBox) findViewById(R.id.checkBox80);
		a80.setOnCheckedChangeListener(this);
		a81 = (CheckBox) findViewById(R.id.checkBox81);
		a81.setOnCheckedChangeListener(this);
		a82 = (CheckBox) findViewById(R.id.checkBox82);
		a82.setOnCheckedChangeListener(this);
		a83 = (CheckBox) findViewById(R.id.checkBox83);
		a83.setOnCheckedChangeListener(this);
		a84 = (CheckBox) findViewById(R.id.checkBox84);
		a84.setOnCheckedChangeListener(this);
		a85 = (CheckBox) findViewById(R.id.checkBox85);
		a85.setOnCheckedChangeListener(this);
		a86 = (CheckBox) findViewById(R.id.checkBox86);
		a86.setOnCheckedChangeListener(this);
		a87 = (CheckBox) findViewById(R.id.checkBox87);
		a87.setOnCheckedChangeListener(this);
		a88 = (CheckBox) findViewById(R.id.checkBox88);
		a88.setOnCheckedChangeListener(this);
		a89 = (CheckBox) findViewById(R.id.checkBox89);
		a89.setOnCheckedChangeListener(this);
		a90 = (CheckBox) findViewById(R.id.checkBox90);
		a90.setOnCheckedChangeListener(this);
		a91 = (CheckBox) findViewById(R.id.checkBox91);
		a91.setOnCheckedChangeListener(this);
		a92 = (CheckBox) findViewById(R.id.checkBox92);
		a92.setOnCheckedChangeListener(this);
		a93 = (CheckBox) findViewById(R.id.checkBox93);
		a93.setOnCheckedChangeListener(this);
		a94 = (CheckBox) findViewById(R.id.checkBox94);
		a94.setOnCheckedChangeListener(this);
		a95 = (CheckBox) findViewById(R.id.checkBox95);
		a95.setOnCheckedChangeListener(this);
		a96 = (CheckBox) findViewById(R.id.checkBox96);
		a96.setOnCheckedChangeListener(this);
		a97 = (CheckBox) findViewById(R.id.checkBox97);
		a97.setOnCheckedChangeListener(this);
		a98 = (CheckBox) findViewById(R.id.checkBox98);
		a98.setOnCheckedChangeListener(this);
		a99 = (CheckBox) findViewById(R.id.checkBox99);
		a99.setOnCheckedChangeListener(this);
		a100 = (CheckBox) findViewById(R.id.checkBox100);
		a100.setOnCheckedChangeListener(this);
		a101 = (CheckBox) findViewById(R.id.checkBox101);
		a101.setOnCheckedChangeListener(this);
		a102 = (CheckBox) findViewById(R.id.checkBox102);
		a102.setOnCheckedChangeListener(this);
		a103 = (CheckBox) findViewById(R.id.checkBox103);
		a103.setOnCheckedChangeListener(this);
		a104 = (CheckBox) findViewById(R.id.checkBox104);
		a104.setOnCheckedChangeListener(this);
		a105 = (CheckBox) findViewById(R.id.checkBox105);
		a105.setOnCheckedChangeListener(this);
		a106 = (CheckBox) findViewById(R.id.checkBox106);
		a106.setOnCheckedChangeListener(this);
		a107 = (CheckBox) findViewById(R.id.checkBox107);
		a107.setOnCheckedChangeListener(this);
		a108 = (CheckBox) findViewById(R.id.checkBox108);
		a108.setOnCheckedChangeListener(this);
		a109 = (CheckBox) findViewById(R.id.checkBox109);
		a109.setOnCheckedChangeListener(this);
		a110 = (CheckBox) findViewById(R.id.checkBox110);
		a110.setOnCheckedChangeListener(this);
		a111 = (CheckBox) findViewById(R.id.checkBox111);
		a111.setOnCheckedChangeListener(this);
		a112 = (CheckBox) findViewById(R.id.checkBox112);
		a112.setOnCheckedChangeListener(this);
		a113 = (CheckBox) findViewById(R.id.checkBox113);
		a113.setOnCheckedChangeListener(this);
		a114 = (CheckBox) findViewById(R.id.checkBox114);
		a114.setOnCheckedChangeListener(this);
		un_sellect_all = (CheckBox) findViewById(R.id.select_all);
		un_sellect_all.setOnCheckedChangeListener(this);

	}

	@Override
	protected void onResume() {

		super.onResume();
	}

}
