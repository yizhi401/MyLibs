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

		// 设置阴影，当抽屉打开时，阴影遮盖主界面露出的部分
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		// 设置抽屉中的列表视图
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mNaviMenuTitles));
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		if (savedInstanceState == null) {
			selectItem(0);
		}
	}

	/**
	 * 抽屉菜单item点击监听器
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
	 * 此方法用于处理菜单中条目选中后跳转的一级Fragment页面
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
	 * 一级界面Fragment
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