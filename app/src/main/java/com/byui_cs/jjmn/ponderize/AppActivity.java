package com.byui_cs.jjmn.ponderize;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.VoiceInteractor;
import android.app.assist.AssistContent;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PersistableBundle;
import android.os.UserHandle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.LoaderManager;
import android.support.v4.app.SharedElementCallback;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.Toolbar;
import android.transition.Scene;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by James Palmer on 19-Feb-17.
 */

public abstract class AppActivity extends AppCompatActivity {
  public AppActivity() {
    super();
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }

  @Override
  protected void attachBaseContext(Context newBase) {
    super.attachBaseContext(newBase);
  }

  @Override
  public Context getBaseContext() {
    return super.getBaseContext();
  }

  @Override
  public void applyOverrideConfiguration(Configuration overrideConfiguration) {
    super.applyOverrideConfiguration(overrideConfiguration);
  }

  @Override
  public AssetManager getAssets() {
    return super.getAssets();
  }

  @Override
  public Intent getIntent() {
    return super.getIntent();
  }

  @Override
  public void setIntent(Intent newIntent) {
    super.setIntent(newIntent);
  }

  @Override
  public WindowManager getWindowManager() {
    return super.getWindowManager();
  }

  @Override
  public Window getWindow() {
    return super.getWindow();
  }

  @Override
  public android.app.LoaderManager getLoaderManager() {
    return super.getLoaderManager();
  }

  @Nullable
  @Override
  public View getCurrentFocus() {
    return super.getCurrentFocus();
  }

  @Override
  public void putExtraData(ExtraData extraData) {
    super.putExtraData(extraData);
  }

  @Override
  public <T extends ExtraData> T getExtraData(Class <T> extraDataClass) {
    return super.getExtraData(extraDataClass);
  }

  @Override
  public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
    return super.onCreateView(parent, name, context, attrs);
  }

  @Override
  public void startActivityForResult(Intent intent, int requestCode, @Nullable Bundle options) {
    super.startActivityForResult(intent, requestCode, options);
  }

  @Override
  public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
    super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
  }

  @Override
  public void startActivity(Intent intent) {
    super.startActivity(intent);
  }

  @Override
  public void startActivity(Intent intent, Bundle options) {
    super.startActivity(intent, options);
  }

  @Override
  public void startActivities(Intent[] intents) {
    super.startActivities(intents);
  }

  @Override
  public void startActivities(Intent[] intents, Bundle options) {
    super.startActivities(intents, options);
  }

  @Override
  public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
    super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
  }

  @Override
  public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
    super.startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags, options);
  }

  @Override
  public void sendBroadcast(Intent intent) {
    super.sendBroadcast(intent);
  }

  @Override
  public void sendBroadcast(Intent intent, String receiverPermission) {
    super.sendBroadcast(intent, receiverPermission);
  }

  @Override
  public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
    super.sendOrderedBroadcast(intent, receiverPermission);
  }

  @Override
  public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
    super.sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
  }

  @Override
  public void sendBroadcastAsUser(Intent intent, UserHandle user) {
    super.sendBroadcastAsUser(intent, user);
  }

  @Override
  public void sendBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission) {
    super.sendBroadcastAsUser(intent, user, receiverPermission);
  }

  @Override
  public void sendOrderedBroadcastAsUser(Intent intent, UserHandle user, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
    super.sendOrderedBroadcastAsUser(intent, user, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
  }

  @Override
  public void sendStickyBroadcast(Intent intent) {
    super.sendStickyBroadcast(intent);
  }

  @Override
  public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
    super.sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
  }

  @Override
  public void removeStickyBroadcast(Intent intent) {
    super.removeStickyBroadcast(intent);
  }

  @Override
  public void sendStickyBroadcastAsUser(Intent intent, UserHandle user) {
    super.sendStickyBroadcastAsUser(intent, user);
  }

  @Override
  public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle user, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
    super.sendStickyOrderedBroadcastAsUser(intent, user, resultReceiver, scheduler, initialCode, initialData, initialExtras);
  }

  @Override
  public void removeStickyBroadcastAsUser(Intent intent, UserHandle user) {
    super.removeStickyBroadcastAsUser(intent, user);
  }

  @Override
  public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
    return super.registerReceiver(receiver, filter);
  }

  @Override
  public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
    return super.registerReceiver(receiver, filter, broadcastPermission, scheduler);
  }

  @Override
  public void unregisterReceiver(BroadcastReceiver receiver) {
    super.unregisterReceiver(receiver);
  }

  @Override
  public ComponentName startService(Intent service) {
    return super.startService(service);
  }

  @Override
  public boolean stopService(Intent name) {
    return super.stopService(name);
  }

  @Override
  public boolean bindService(Intent service, ServiceConnection conn, int flags) {
    return super.bindService(service, conn, flags);
  }

  @Override
  public void unbindService(ServiceConnection conn) {
    super.unbindService(conn);
  }

  @Override
  public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
    return super.startInstrumentation(className, profileFile, arguments);
  }

  @Override
  public boolean startActivityIfNeeded(Intent intent, int requestCode) {
    return super.startActivityIfNeeded(intent, requestCode);
  }

  @Override
  public boolean startActivityIfNeeded(Intent intent, int requestCode, Bundle options) {
    return super.startActivityIfNeeded(intent, requestCode, options);
  }

  @Override
  public boolean startNextMatchingActivity(Intent intent) {
    return super.startNextMatchingActivity(intent);
  }

  @Override
  public boolean startNextMatchingActivity(Intent intent, Bundle options) {
    return super.startNextMatchingActivity(intent, options);
  }

  @Override
  public void startActivityFromChild(Activity child, Intent intent, int requestCode) {
    super.startActivityFromChild(child, intent, requestCode);
  }

  @Override
  public void startActivityFromChild(Activity child, Intent intent, int requestCode, Bundle options) {
    super.startActivityFromChild(child, intent, requestCode, options);
  }

  @Override
  public void startActivityFromFragment(android.app.Fragment fragment, Intent intent, int requestCode) {
    super.startActivityFromFragment(fragment, intent, requestCode);
  }

  @Override
  public void startActivityFromFragment(android.app.Fragment fragment, Intent intent, int requestCode, Bundle options) {
    super.startActivityFromFragment(fragment, intent, requestCode, options);
  }

  @Override
  public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
    super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
  }

  @Override
  public void startIntentSenderFromChild(Activity child, IntentSender intent, int requestCode, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
    super.startIntentSenderFromChild(child, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
  }

  @Override
  public void overridePendingTransition(int enterAnim, int exitAnim) {
    super.overridePendingTransition(enterAnim, exitAnim);
  }

  @Nullable
  @Override
  public Uri getReferrer() {
    return super.getReferrer();
  }

  @Override
  public Uri onProvideReferrer() {
    return super.onProvideReferrer();
  }

  @Nullable
  @Override
  public String getCallingPackage() {
    return super.getCallingPackage();
  }

  @Nullable
  @Override
  public ComponentName getCallingActivity() {
    return super.getCallingActivity();
  }

  @Override
  public void setVisible(boolean visible) {
    super.setVisible(visible);
  }

  @Override
  public boolean isFinishing() {
    return super.isFinishing();
  }

  @Override
  public boolean isDestroyed() {
    return super.isDestroyed();
  }

  @Override
  public boolean isChangingConfigurations() {
    return super.isChangingConfigurations();
  }

  @Override
  public void recreate() {
    super.recreate();
  }

  @Override
  public void finish() {
    super.finish();
  }

  @Override
  public void finishAffinity() {
    super.finishAffinity();
  }

  @Override
  public void finishFromChild(Activity child) {
    super.finishFromChild(child);
  }

  @Override
  public void finishAfterTransition() {
    super.finishAfterTransition();
  }

  @Override
  public void finishActivity(int requestCode) {
    super.finishActivity(requestCode);
  }

  @Override
  public void finishActivityFromChild(Activity child, int requestCode) {
    super.finishActivityFromChild(child, requestCode);
  }

  @Override
  public void finishAndRemoveTask() {
    super.finishAndRemoveTask();
  }

  @Override
  public boolean releaseInstance() {
    return super.releaseInstance();
  }

  @Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
  }

  @Override
  public void onActivityReenter(int resultCode, Intent data) {
    super.onActivityReenter(resultCode, data);
  }

  @Override
  public PendingIntent createPendingResult(int requestCode, Intent data, int flags) {
    return super.createPendingResult(requestCode, data, flags);
  }

  @Override
  public void setRequestedOrientation(int requestedOrientation) {
    super.setRequestedOrientation(requestedOrientation);
  }

  @Override
  public int getRequestedOrientation() {
    return super.getRequestedOrientation();
  }

  @Override
  public int getTaskId() {
    return super.getTaskId();
  }

  @Override
  public boolean isTaskRoot() {
    return super.isTaskRoot();
  }

  @Override
  public boolean moveTaskToBack(boolean nonRoot) {
    return super.moveTaskToBack(nonRoot);
  }

  @NonNull
  @Override
  public String getLocalClassName() {
    return super.getLocalClassName();
  }

  @Override
  public ComponentName getComponentName() {
    return super.getComponentName();
  }

  @Override
  public SharedPreferences getPreferences(int mode) {
    return super.getPreferences(mode);
  }

  @Override
  public Object getSystemService(String name) {
    return super.getSystemService(name);
  }

  @Override
  public String getSystemServiceName(Class <?> serviceClass) {
    return super.getSystemServiceName(serviceClass);
  }

  @Override
  public int checkPermission(String permission, int pid, int uid) {
    return super.checkPermission(permission, pid, uid);
  }

  @Override
  public int checkCallingPermission(String permission) {
    return super.checkCallingPermission(permission);
  }

  @Override
  public int checkCallingOrSelfPermission(String permission) {
    return super.checkCallingOrSelfPermission(permission);
  }

  @Override
  public int checkSelfPermission(String permission) {
    return super.checkSelfPermission(permission);
  }

  @Override
  public void enforcePermission(String permission, int pid, int uid, String message) {
    super.enforcePermission(permission, pid, uid, message);
  }

  @Override
  public void enforceCallingPermission(String permission, String message) {
    super.enforceCallingPermission(permission, message);
  }

  @Override
  public void enforceCallingOrSelfPermission(String permission, String message) {
    super.enforceCallingOrSelfPermission(permission, message);
  }

  @Override
  public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
    super.grantUriPermission(toPackage, uri, modeFlags);
  }

  @Override
  public void revokeUriPermission(Uri uri, int modeFlags) {
    super.revokeUriPermission(uri, modeFlags);
  }

  @Override
  public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
    return super.checkUriPermission(uri, pid, uid, modeFlags);
  }

  @Override
  public int checkCallingUriPermission(Uri uri, int modeFlags) {
    return super.checkCallingUriPermission(uri, modeFlags);
  }

  @Override
  public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
    return super.checkCallingOrSelfUriPermission(uri, modeFlags);
  }

  @Override
  public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
    return super.checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
  }

  @Override
  public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
    super.enforceUriPermission(uri, pid, uid, modeFlags, message);
  }

  @Override
  public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
    super.enforceCallingUriPermission(uri, modeFlags, message);
  }

  @Override
  public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
    super.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
  }

  @Override
  public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
    super.enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
  }

  @Override
  public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
    return super.createPackageContext(packageName, flags);
  }

  @Override
  public Context createConfigurationContext(Configuration overrideConfiguration) {
    return super.createConfigurationContext(overrideConfiguration);
  }

  @Override
  public Context createDisplayContext(Display display) {
    return super.createDisplayContext(display);
  }

  @Override
  public boolean isRestricted() {
    return super.isRestricted();
  }

  @Override
  public Context createDeviceProtectedStorageContext() {
    return super.createDeviceProtectedStorageContext();
  }

  @Override
  public boolean isDeviceProtectedStorage() {
    return super.isDeviceProtectedStorage();
  }

  @Override
  public void setTitle(CharSequence title) {
    super.setTitle(title);
  }

  @Override
  public void setTitle(int titleId) {
    super.setTitle(titleId);
  }

  @Override
  public void setTitleColor(int textColor) {
    super.setTitleColor(textColor);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
  }

  @Override
  public boolean onKeyShortcut(int keyCode, KeyEvent event) {
    return super.onKeyShortcut(keyCode, event);
  }

  @Override
  public boolean onTouchEvent(MotionEvent event) {
    return super.onTouchEvent(event);
  }

  @Override
  public boolean onTrackballEvent(MotionEvent event) {
    return super.onTrackballEvent(event);
  }

  @Override
  public boolean onGenericMotionEvent(MotionEvent event) {
    return super.onGenericMotionEvent(event);
  }

  @Override
  public void onUserInteraction() {
    super.onUserInteraction();
  }

  @Override
  public void onWindowAttributesChanged(WindowManager.LayoutParams params) {
    super.onWindowAttributesChanged(params);
  }

  @Override
  public void supportFinishAfterTransition() {
    super.supportFinishAfterTransition();
  }

  @Override
  public void setEnterSharedElementCallback(SharedElementCallback callback) {
    super.setEnterSharedElementCallback(callback);
  }

  @Override
  public void setExitSharedElementCallback(SharedElementCallback listener) {
    super.setExitSharedElementCallback(listener);
  }

  @Override
  public void supportPostponeEnterTransition() {
    super.supportPostponeEnterTransition();
  }

  @Override
  public void supportStartPostponedEnterTransition() {
    super.supportStartPostponedEnterTransition();
  }

  @Override
  public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
    super.onMultiWindowModeChanged(isInMultiWindowMode);
  }

  @Override
  public boolean isInMultiWindowMode() {
    return super.isInMultiWindowMode();
  }

  @Override
  public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
    super.onPictureInPictureModeChanged(isInPictureInPictureMode);
  }

  @Override
  public boolean isInPictureInPictureMode() {
    return super.isInPictureInPictureMode();
  }

  @Override
  public void enterPictureInPictureMode() {
    super.enterPictureInPictureMode();
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
  }

  @Override
  public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onRestoreInstanceState(savedInstanceState, persistentState);
  }

  @Override
  public View onCreateView(String name, Context context, AttributeSet attrs) {
    return super.onCreateView(name, context, attrs);
  }

  @Override
  public void startIntentSenderForResult(IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
    super.startIntentSenderForResult(intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags);
  }

  @Override
  public boolean onCreatePanelMenu(int featureId, Menu menu) {
    return super.onCreatePanelMenu(featureId, menu);
  }

  @Override
  public void setTheme(@StyleRes int resid) {
    super.setTheme(resid);
  }

  @Override
  public Resources.Theme getTheme() {
    return super.getTheme();
  }

  @Override
  public ClassLoader getClassLoader() {
    return super.getClassLoader();
  }

  @Override
  public String getPackageName() {
    return super.getPackageName();
  }

  @Override
  public ApplicationInfo getApplicationInfo() {
    return super.getApplicationInfo();
  }

  @Override
  public String getPackageResourcePath() {
    return super.getPackageResourcePath();
  }

  @Override
  public String getPackageCodePath() {
    return super.getPackageCodePath();
  }

  @Override
  public SharedPreferences getSharedPreferences(String name, int mode) {
    return super.getSharedPreferences(name, mode);
  }

  @Override
  public boolean moveSharedPreferencesFrom(Context sourceContext, String name) {
    return super.moveSharedPreferencesFrom(sourceContext, name);
  }

  @Override
  public boolean deleteSharedPreferences(String name) {
    return super.deleteSharedPreferences(name);
  }

  @Override
  public FileInputStream openFileInput(String name) throws FileNotFoundException {
    return super.openFileInput(name);
  }

  @Override
  public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
    return super.openFileOutput(name, mode);
  }

  @Override
  public boolean deleteFile(String name) {
    return super.deleteFile(name);
  }

  @Override
  public File getFileStreamPath(String name) {
    return super.getFileStreamPath(name);
  }

  @Override
  public String[] fileList() {
    return super.fileList();
  }

  @Override
  public File getDataDir() {
    return super.getDataDir();
  }

  @Override
  public File getFilesDir() {
    return super.getFilesDir();
  }

  @Override
  public File getNoBackupFilesDir() {
    return super.getNoBackupFilesDir();
  }

  @Override
  public File getExternalFilesDir(String type) {
    return super.getExternalFilesDir(type);
  }

  @Override
  public File[] getExternalFilesDirs(String type) {
    return super.getExternalFilesDirs(type);
  }

  @Override
  public File getObbDir() {
    return super.getObbDir();
  }

  @Override
  public File[] getObbDirs() {
    return super.getObbDirs();
  }

  @Override
  public File getCacheDir() {
    return super.getCacheDir();
  }

  @Override
  public File getCodeCacheDir() {
    return super.getCodeCacheDir();
  }

  @Override
  public File getExternalCacheDir() {
    return super.getExternalCacheDir();
  }

  @Override
  public File[] getExternalCacheDirs() {
    return super.getExternalCacheDirs();
  }

  @Override
  public File[] getExternalMediaDirs() {
    return super.getExternalMediaDirs();
  }

  @Override
  public File getDir(String name, int mode) {
    return super.getDir(name, mode);
  }

  @Override
  public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory) {
    return super.openOrCreateDatabase(name, mode, factory);
  }

  @Override
  public SQLiteDatabase openOrCreateDatabase(String name, int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
    return super.openOrCreateDatabase(name, mode, factory, errorHandler);
  }

  @Override
  public boolean moveDatabaseFrom(Context sourceContext, String name) {
    return super.moveDatabaseFrom(sourceContext, name);
  }

  @Override
  public boolean deleteDatabase(String name) {
    return super.deleteDatabase(name);
  }

  @Override
  public File getDatabasePath(String name) {
    return super.getDatabasePath(name);
  }

  @Override
  public String[] databaseList() {
    return super.databaseList();
  }

  @Override
  public Drawable getWallpaper() {
    return super.getWallpaper();
  }

  @Override
  public Drawable peekWallpaper() {
    return super.peekWallpaper();
  }

  @Override
  public int getWallpaperDesiredMinimumWidth() {
    return super.getWallpaperDesiredMinimumWidth();
  }

  @Override
  public int getWallpaperDesiredMinimumHeight() {
    return super.getWallpaperDesiredMinimumHeight();
  }

  @Override
  public void setWallpaper(Bitmap bitmap) throws IOException {
    super.setWallpaper(bitmap);
  }

  @Override
  public void setWallpaper(InputStream data) throws IOException {
    super.setWallpaper(data);
  }

  @Override
  public void clearWallpaper() throws IOException {
    super.clearWallpaper();
  }

  @Override
  protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
    super.onApplyThemeResource(theme, resid, first);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
  }

  @Override
  public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
    super.onPostCreate(savedInstanceState, persistentState);
  }

  @Nullable
  @Override
  public ActionBar getSupportActionBar() {
    return super.getSupportActionBar();
  }

  @Override
  public void setSupportActionBar(@Nullable Toolbar toolbar) {
    super.setSupportActionBar(toolbar);
  }

  @Override
  public MenuInflater getMenuInflater() {
    return super.getMenuInflater();
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
  }

  @Override
  public void setContentView(View view) {
    super.setContentView(view);
  }

  @Override
  public void setContentView(View view, ViewGroup.LayoutParams params) {
    super.setContentView(view, params);
  }

  @Override
  public void addContentView(View view, ViewGroup.LayoutParams params) {
    super.addContentView(view, params);
  }

  @Override
  public TransitionManager getContentTransitionManager() {
    return super.getContentTransitionManager();
  }

  @Override
  public void setContentTransitionManager(TransitionManager tm) {
    super.setContentTransitionManager(tm);
  }

  @Override
  public Scene getContentScene() {
    return super.getContentScene();
  }

  @Override
  public void setFinishOnTouchOutside(boolean finish) {
    super.setFinishOnTouchOutside(finish);
  }

  @Override
  public boolean onKeyDown(int keyCode, KeyEvent event) {
    return super.onKeyDown(keyCode, event);
  }

  @Override
  public boolean onKeyLongPress(int keyCode, KeyEvent event) {
    return super.onKeyLongPress(keyCode, event);
  }

  @Override
  public boolean onKeyUp(int keyCode, KeyEvent event) {
    return super.onKeyUp(keyCode, event);
  }

  @Override
  public boolean onKeyMultiple(int keyCode, int repeatCount, KeyEvent event) {
    return super.onKeyMultiple(keyCode, repeatCount, event);
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
  }

  @Override
  public int getChangingConfigurations() {
    return super.getChangingConfigurations();
  }

  @Nullable
  @Override
  public Object getLastNonConfigurationInstance() {
    return super.getLastNonConfigurationInstance();
  }

  @Override
  protected void onPostResume() {
    super.onPostResume();
  }

  @Override
  public boolean isVoiceInteraction() {
    return super.isVoiceInteraction();
  }

  @Override
  public boolean isVoiceInteractionRoot() {
    return super.isVoiceInteractionRoot();
  }

  @Override
  public VoiceInteractor getVoiceInteractor() {
    return super.getVoiceInteractor();
  }

  @Override
  public boolean isLocalVoiceInteractionSupported() {
    return super.isLocalVoiceInteractionSupported();
  }

  @Override
  public void startLocalVoiceInteraction(Bundle privateOptions) {
    super.startLocalVoiceInteraction(privateOptions);
  }

  @Override
  public void onLocalVoiceInteractionStarted() {
    super.onLocalVoiceInteractionStarted();
  }

  @Override
  public void onLocalVoiceInteractionStopped() {
    super.onLocalVoiceInteractionStopped();
  }

  @Override
  public void stopLocalVoiceInteraction() {
    super.stopLocalVoiceInteraction();
  }

  @Override
  protected void onResumeFragments() {
    super.onResumeFragments();
  }

  @Override
  public boolean onPreparePanel(int featureId, View view, Menu menu) {
    return super.onPreparePanel(featureId, view, menu);
  }

  @Override
  protected boolean onPrepareOptionsPanel(View view, Menu menu) {
    return super.onPrepareOptionsPanel(view, menu);
  }

  @Override
  protected void onStart() {
    super.onStart();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
  }

  @Override
  protected void onStop() {
    super.onStop();
  }

  @Override
  public Object onRetainCustomNonConfigurationInstance() {
    return super.onRetainCustomNonConfigurationInstance();
  }

  @Override
  public Object getLastCustomNonConfigurationInstance() {
    return super.getLastCustomNonConfigurationInstance();
  }

  @Override
  public View findViewById(@IdRes int id) {
    return super.findViewById(id);
  }

  @Nullable
  @Override
  public android.app.ActionBar getActionBar() {
    return super.getActionBar();
  }

  @Override
  public void setActionBar(android.widget.Toolbar toolbar) {
    super.setActionBar(toolbar);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
  }

  @Override
  public void reportFullyDrawn() {
    super.reportFullyDrawn();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
  }

  @Override
  public void onTrimMemory(int level) {
    super.onTrimMemory(level);
  }

  @Override
  public android.app.FragmentManager getFragmentManager() {
    return super.getFragmentManager();
  }

  @Override
  public void onAttachFragment(android.app.Fragment fragment) {
    super.onAttachFragment(fragment);
  }

  @Override
  public void startManagingCursor(Cursor c) {
    super.startManagingCursor(c);
  }

  @Override
  public void stopManagingCursor(Cursor c) {
    super.stopManagingCursor(c);
  }

  @Override
  protected void onTitleChanged(CharSequence title, int color) {
    super.onTitleChanged(title, color);
  }

  @Override
  protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
    super.onChildTitleChanged(childActivity, title);
  }

  @Override
  public void setTaskDescription(ActivityManager.TaskDescription taskDescription) {
    super.setTaskDescription(taskDescription);
  }

  @Override
  public boolean supportRequestWindowFeature(int featureId) {
    return super.supportRequestWindowFeature(featureId);
  }

  @Override
  public void supportInvalidateOptionsMenu() {
    super.supportInvalidateOptionsMenu();
  }

  @Override
  public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
    super.dump(prefix, fd, writer, args);
  }

  @Override
  public boolean isImmersive() {
    return super.isImmersive();
  }

  @Override
  public boolean requestVisibleBehind(boolean visible) {
    return super.requestVisibleBehind(visible);
  }

  @Override
  public void onVisibleBehindCanceled() {
    super.onVisibleBehindCanceled();
  }

  @Override
  public void onEnterAnimationComplete() {
    super.onEnterAnimationComplete();
  }

  @Override
  public void setImmersive(boolean i) {
    super.setImmersive(i);
  }

  @Override
  public void setVrModeEnabled(boolean enabled, ComponentName requestedComponent) throws PackageManager.NameNotFoundException {
    super.setVrModeEnabled(enabled, requestedComponent);
  }

  @Nullable
  @Override
  public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback) {
    return super.startActionMode(callback);
  }

  @Nullable
  @Override
  public android.view.ActionMode startActionMode(android.view.ActionMode.Callback callback, int type) {
    return super.startActionMode(callback, type);
  }

  @Nullable
  @Override
  public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback) {
    return super.onWindowStartingActionMode(callback);
  }

  @Nullable
  @Override
  public android.view.ActionMode onWindowStartingActionMode(android.view.ActionMode.Callback callback, int type) {
    return super.onWindowStartingActionMode(callback, type);
  }

  @Override
  public void onActionModeStarted(android.view.ActionMode mode) {
    super.onActionModeStarted(mode);
  }

  @Override
  public void onActionModeFinished(android.view.ActionMode mode) {
    super.onActionModeFinished(mode);
  }

  @Override
  public boolean shouldUpRecreateTask(Intent targetIntent) {
    return super.shouldUpRecreateTask(targetIntent);
  }

  @Override
  public boolean navigateUpTo(Intent upIntent) {
    return super.navigateUpTo(upIntent);
  }

  @Override
  public boolean navigateUpToFromChild(Activity child, Intent upIntent) {
    return super.navigateUpToFromChild(child, upIntent);
  }

  @Nullable
  @Override
  public Intent getParentActivityIntent() {
    return super.getParentActivityIntent();
  }

  @Override
  public void setEnterSharedElementCallback(android.app.SharedElementCallback callback) {
    super.setEnterSharedElementCallback(callback);
  }

  @Override
  public void setExitSharedElementCallback(android.app.SharedElementCallback callback) {
    super.setExitSharedElementCallback(callback);
  }

  @Override
  public void postponeEnterTransition() {
    super.postponeEnterTransition();
  }

  @Override
  public void startPostponedEnterTransition() {
    super.startPostponedEnterTransition();
  }

  @Override
  public DragAndDropPermissions requestDragAndDropPermissions(DragEvent event) {
    return super.requestDragAndDropPermissions(event);
  }

  @Override
  public void startLockTask() {
    super.startLockTask();
  }

  @Override
  public void stopLockTask() {
    super.stopLockTask();
  }

  @Override
  public void showLockTaskEscapeMessage() {
    super.showLockTaskEscapeMessage();
  }

  @Override
  public void onAttachFragment(Fragment fragment) {
    super.onAttachFragment(fragment);
  }

  @Override
  public FragmentManager getSupportFragmentManager() {
    return super.getSupportFragmentManager();
  }

  @Override
  public LoaderManager getSupportLoaderManager() {
    return super.getSupportLoaderManager();
  }

  @Override
  public void startActivityForResult(Intent intent, int requestCode) {
    super.startActivityForResult(intent, requestCode);
  }

  @Override
  public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
  }

  @Override
  public boolean shouldShowRequestPermissionRationale(String permission) {
    return super.shouldShowRequestPermissionRationale(permission);
  }

  @Override
  public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode) {
    super.startActivityFromFragment(fragment, intent, requestCode);
  }

  @Override
  public void startActivityFromFragment(Fragment fragment, Intent intent, int requestCode, @Nullable Bundle options) {
    super.startActivityFromFragment(fragment, intent, requestCode, options);
  }

  @Override
  public void startIntentSenderFromFragment(Fragment fragment, IntentSender intent, int requestCode, @Nullable Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags, Bundle options) throws IntentSender.SendIntentException {
    super.startIntentSenderFromFragment(fragment, intent, requestCode, fillInIntent, flagsMask, flagsValues, extraFlags, options);
  }

  @Override
  public void invalidateOptionsMenu() {
    super.invalidateOptionsMenu();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onPrepareOptionsMenu(Menu menu) {
    return super.onPrepareOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigateUp() {
    return super.onNavigateUp();
  }

  @Override
  public boolean onNavigateUpFromChild(Activity child) {
    return super.onNavigateUpFromChild(child);
  }

  @Override
  public void onCreateNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
    super.onCreateNavigateUpTaskStack(builder);
  }

  @Override
  public void onPrepareNavigateUpTaskStack(android.app.TaskStackBuilder builder) {
    super.onPrepareNavigateUpTaskStack(builder);
  }

  @Override
  public void onOptionsMenuClosed(Menu menu) {
    super.onOptionsMenuClosed(menu);
  }

  @Override
  public void openOptionsMenu() {
    super.openOptionsMenu();
  }

  @Override
  public void closeOptionsMenu() {
    super.closeOptionsMenu();
  }

  @Override
  public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
    super.onCreateContextMenu(menu, v, menuInfo);
  }

  @Override
  public void registerForContextMenu(View view) {
    super.registerForContextMenu(view);
  }

  @Override
  public void unregisterForContextMenu(View view) {
    super.unregisterForContextMenu(view);
  }

  @Override
  public void openContextMenu(View view) {
    super.openContextMenu(view);
  }

  @Override
  public void closeContextMenu() {
    super.closeContextMenu();
  }

  @Override
  public boolean onContextItemSelected(MenuItem item) {
    return super.onContextItemSelected(item);
  }

  @Override
  public void onContextMenuClosed(Menu menu) {
    super.onContextMenuClosed(menu);
  }

  @Override
  protected Dialog onCreateDialog(int id) {
    return super.onCreateDialog(id);
  }

  @Nullable
  @Override
  protected Dialog onCreateDialog(int id, Bundle args) {
    return super.onCreateDialog(id, args);
  }

  @Override
  protected void onPrepareDialog(int id, Dialog dialog) {
    super.onPrepareDialog(id, dialog);
  }

  @Override
  protected void onPrepareDialog(int id, Dialog dialog, Bundle args) {
    super.onPrepareDialog(id, dialog, args);
  }

  @Override
  public boolean onSearchRequested(SearchEvent searchEvent) {
    return super.onSearchRequested(searchEvent);
  }

  @Override
  public boolean onSearchRequested() {
    return super.onSearchRequested();
  }

  @Override
  public void startSearch(String initialQuery, boolean selectInitialQuery, Bundle appSearchData, boolean globalSearch) {
    super.startSearch(initialQuery, selectInitialQuery, appSearchData, globalSearch);
  }

  @Override
  public void triggerSearch(String query, Bundle appSearchData) {
    super.triggerSearch(query, appSearchData);
  }

  @Override
  public void takeKeyEvents(boolean get) {
    super.takeKeyEvents(get);
  }

  @NonNull
  @Override
  public LayoutInflater getLayoutInflater() {
    return super.getLayoutInflater();
  }

  @Override
  public void onSupportActionModeStarted(@NonNull ActionMode mode) {
    super.onSupportActionModeStarted(mode);
  }

  @Override
  public void onSupportActionModeFinished(@NonNull ActionMode mode) {
    super.onSupportActionModeFinished(mode);
  }

  @Nullable
  @Override
  public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
    return super.onWindowStartingSupportActionMode(callback);
  }

  @Nullable
  @Override
  public ActionMode startSupportActionMode(@NonNull ActionMode.Callback callback) {
    return super.startSupportActionMode(callback);
  }

  @Override
  public void setSupportProgressBarVisibility(boolean visible) {
    super.setSupportProgressBarVisibility(visible);
  }

  @Override
  public void setSupportProgressBarIndeterminateVisibility(boolean visible) {
    super.setSupportProgressBarIndeterminateVisibility(visible);
  }

  @Override
  public void setSupportProgressBarIndeterminate(boolean indeterminate) {
    super.setSupportProgressBarIndeterminate(indeterminate);
  }

  @Override
  public void setSupportProgress(int progress) {
    super.setSupportProgress(progress);
  }

  @Override
  public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
    super.onCreateSupportNavigateUpTaskStack(builder);
  }

  @Override
  public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
    super.onPrepareSupportNavigateUpTaskStack(builder);
  }

  @Override
  public boolean onSupportNavigateUp() {
    return super.onSupportNavigateUp();
  }

  @Nullable
  @Override
  public Intent getSupportParentActivityIntent() {
    return super.getSupportParentActivityIntent();
  }

  @Override
  public boolean supportShouldUpRecreateTask(@NonNull Intent targetIntent) {
    return super.supportShouldUpRecreateTask(targetIntent);
  }

  @Override
  public void supportNavigateUpTo(@NonNull Intent upIntent) {
    super.supportNavigateUpTo(upIntent);
  }

  @Override
  public void onContentChanged() {
    super.onContentChanged();
  }

  @Override
  public void onWindowFocusChanged(boolean hasFocus) {
    super.onWindowFocusChanged(hasFocus);
  }

  @Override
  public void onAttachedToWindow() {
    super.onAttachedToWindow();
  }

  @Override
  public void onDetachedFromWindow() {
    super.onDetachedFromWindow();
  }

  @Override
  public boolean hasWindowFocus() {
    return super.hasWindowFocus();
  }

  @Override
  public void onSupportContentChanged() {
    super.onSupportContentChanged();
  }

  @Nullable
  @Override
  public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate() {
    return super.getDrawerToggleDelegate();
  }

  @Override
  public boolean onMenuOpened(int featureId, Menu menu) {
    return super.onMenuOpened(featureId, menu);
  }

  @Override
  public void onPanelClosed(int featureId, Menu menu) {
    super.onPanelClosed(featureId, menu);
  }

  @Override
  protected void onPause() {
    super.onPause();
  }

  @Override
  protected void onUserLeaveHint() {
    super.onUserLeaveHint();
  }

  @Override
  public boolean onCreateThumbnail(Bitmap outBitmap, Canvas canvas) {
    return super.onCreateThumbnail(outBitmap, canvas);
  }

  @Nullable
  @Override
  public CharSequence onCreateDescription() {
    return super.onCreateDescription();
  }

  @Override
  public void onProvideAssistData(Bundle data) {
    super.onProvideAssistData(data);
  }

  @Override
  public void onProvideAssistContent(AssistContent outContent) {
    super.onProvideAssistContent(outContent);
  }

  @Override
  public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> data, Menu menu, int deviceId) {
    super.onProvideKeyboardShortcuts(data, menu, deviceId);
  }

  @Override
  public boolean showAssist(Bundle args) {
    return super.showAssist(args);
  }

  @Override
  protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
  }

  @Override
  public void onStateNotSaved() {
    super.onStateNotSaved();
  }

  @Override
  protected void onResume() {
    super.onResume();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
  }

  @Override
  public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
    super.onSaveInstanceState(outState, outPersistentState);
  }

  @NonNull
  @Override
  public AppCompatDelegate getDelegate() {
    return super.getDelegate();
  }

  @Override
  public boolean dispatchKeyEvent(KeyEvent event) {
    return super.dispatchKeyEvent(event);
  }

  @Override
  public boolean dispatchKeyShortcutEvent(KeyEvent event) {
    return super.dispatchKeyShortcutEvent(event);
  }

  @Override
  public boolean dispatchTouchEvent(MotionEvent ev) {
    return super.dispatchTouchEvent(ev);
  }

  @Override
  public boolean dispatchTrackballEvent(MotionEvent ev) {
    return super.dispatchTrackballEvent(ev);
  }

  @Override
  public boolean dispatchGenericMotionEvent(MotionEvent ev) {
    return super.dispatchGenericMotionEvent(ev);
  }

  @Override
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent event) {
    return super.dispatchPopulateAccessibilityEvent(event);
  }

  @Nullable
  @Override
  public View onCreatePanelView(int featureId) {
    return super.onCreatePanelView(featureId);
  }

  @Override
  public Resources getResources() {
    return super.getResources();
  }

  @Override
  public PackageManager getPackageManager() {
    return super.getPackageManager();
  }

  @Override
  public ContentResolver getContentResolver() {
    return super.getContentResolver();
  }

  @Override
  public Looper getMainLooper() {
    return super.getMainLooper();
  }

  @Override
  public Context getApplicationContext() {
    return super.getApplicationContext();
  }

  @Override
  public void registerComponentCallbacks(ComponentCallbacks callback) {
    super.registerComponentCallbacks(callback);
  }

  @Override
  public void unregisterComponentCallbacks(ComponentCallbacks callback) {
    super.unregisterComponentCallbacks(callback);
  }
}
