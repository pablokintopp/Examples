package pablokintopp.com.mvvmtemplate.util;

import android.content.Context;

import com.afollestad.materialdialogs.MaterialDialog;

import pablokintopp.com.mvvmtemplate.R;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

public class DialogBuilder {

    public static MaterialDialog.Builder progressDialog(Context context, int title, int content) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .canceledOnTouchOutside(false)
                .progress(true, 0);
    }

    public static MaterialDialog.Builder infoDialog(Context context, int title, int content) {
        return new MaterialDialog.Builder(context)
                .title(title)
                .content(content)
                .positiveText(R.string.dialog_action_ok)
                .positiveColorRes(R.color.colorPrimary);
    }

}
