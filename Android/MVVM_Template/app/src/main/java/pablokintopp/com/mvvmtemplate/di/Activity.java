package pablokintopp.com.mvvmtemplate.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Pablo Kintopp, Mar 2018.
 */

@Scope
@Retention(RUNTIME)
public @interface Activity {
}