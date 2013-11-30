package com.bros.xienan.peter.mylibs.ui.mybookshelf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import android.app.Fragment;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bros.xienan.peter.mylibs.R;

public class MyBookShelfFragment extends Fragment {

	Button button;

	ImageView imageView;

	public MyBookShelfFragment() {

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		this.createExternalStoragePrivateFile();

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_mybookshelf,
				container, false);

		int imageId = getResources().getIdentifier("icon1", "drawable",
				getActivity().getPackageName());
		imageView = (ImageView) rootView.findViewById(R.id.image);
		imageView.setImageResource(imageId);

		button = (Button) rootView.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				readFromExternalStorage();
			}

		});

		return rootView;
	}

	void readFromExternalStorage() {

		File sdCard = Environment.getExternalStorageDirectory();

		File dir = new File(sdCard.getAbsolutePath() + "/MyLibs/Books");

		File file = new File(dir, "DemoFile.jpg");

		AssetManager assets = getActivity().getAssets();

		InputStream is;
		Bitmap bitmap = null;
		try {
			is = assets.open("Books/SpongeBob.zip");
			ZipInputStream zis = new ZipInputStream(is);
			ZipEntry ze = null;
			while ((ze = zis.getNextEntry()) != null) {
				if (ze.getName().equals("SpongeBob/images/bookcover.jpg")) {
					bitmap = BitmapFactory.decodeStream(zis);
					break;
				}
			}
		} catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		BitmapFactory.Options options = new BitmapFactory.Options();
//
//		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//
//		Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(),
//				options);

		imageView.setImageBitmap(bitmap);
	}

	void createExternalStoragePrivateFile() {
		// Create a path where we will place our private file on external
		// storage.

		File sdCard = Environment.getExternalStorageDirectory();

		File dir = new File(sdCard.getAbsolutePath() + "/MyLibs/Books");

		dir.mkdirs();

		File file = new File(dir, "DemoFile.jpg");

		try {
			// Very simple code to copy a picture from the application's
			// resource into the external file. Note that this code does
			// no error checking, and assumes the picture is small (does not
			// try to copy it in chunks). Note that if external storage is
			// not currently mounted this will silently fail.
			InputStream is = getResources().openRawResource(R.drawable.icon1);
			OutputStream os = new FileOutputStream(file);
			byte[] data = new byte[is.available()];
			is.read(data);
			os.write(data);
			is.close();
			os.close();
		} catch (IOException e) {
			// Unable to create file, likely because external storage is
			// not currently mounted.
			Log.w("ExternalStorage", "Error writing " + file, e);
		}
	}

	void deleteExternalStoragePrivateFile() {
		// Get path for the file on external storage. If external
		// storage is not currently mounted this will fail.
		File file = new File(getActivity().getExternalFilesDir(null),
				"DemoFile.jpg");
		if (file != null) {
			file.delete();
		}
	}

	boolean hasExternalStoragePrivateFile() {
		// Get path for the file on external storage. If external
		// storage is not currently mounted this will fail.
		File file = new File(getActivity().getExternalFilesDir(null),
				"DemoFile.jpg");
		if (file != null) {
			return file.exists();
		}
		return false;
	}

}
