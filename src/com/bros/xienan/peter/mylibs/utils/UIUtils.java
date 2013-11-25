package com.bros.xienan.peter.mylibs.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class UIUtils
{
	public static void jumpToActivity(Context context,
			Class<? extends Activity> clazz)
	{
		Intent intent = new Intent(context, clazz);
		context.startActivity(intent);
	}
}
