package com.bros.xienan.peter.mylibs.ui.slidemain;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bros.xienan.peter.mylibs.R;
import com.bros.xienan.peter.mylibs.ui.mybookshelf.MyBookShelfFragment;

public class SlideMainActivity extends Activity {
	private DrawerLayout mDrawerLayout;

	private ListView mDrawerList;

	private String[] mNaviMenuTitles;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mNaviMenuTitles = getResources().getStringArray(
				R.array.navi_menu_title_array);
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// ������Ӱ���������ʱ����Ӱ�ڸ�������¶���Ĳ���
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// ���ó����е��б���ͼ
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mNaviMenuTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	/**
	 * ����˵�item���������
	 */
	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			selectItem(position);
		}
	}

	/**
	 * �˷������ڴ���˵�����Ŀѡ�к���ת��һ��Fragmentҳ��
	 */
	private void selectItem(int position) {

		FragmentManager fragmentManager = getFragmentManager();
		Fragment fragment;
		Bundle args = new Bundle();

		switch (position) {

		case 0:
			fragment = new MyBookShelfFragment();
			fragment.setArguments(args);
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			break;
		case 1:
			fragment = new TestFragment();
			fragment.setArguments(args);
			fragmentManager.beginTransaction()
					.replace(R.id.content_frame, fragment).commit();
			break;
		default:
			break;
		}

		mDrawerList.setItemChecked(position, true);
		mDrawerLayout.closeDrawer(mDrawerList);
	}

	/**
	 * һ������Fragment
	 */
	public static class TestFragment extends Fragment {
		public TestFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_test, container,
					false);

			int imageId = getResources().getIdentifier("icon2", "drawable",
					getActivity().getPackageName());
			((ImageView) rootView.findViewById(R.id.image))
					.setImageResource(imageId);
			return rootView;
		}
	}
}