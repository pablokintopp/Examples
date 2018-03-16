package pablokintopp.com.mvvmtemplate.util;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

public abstract class SimpleTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
}
