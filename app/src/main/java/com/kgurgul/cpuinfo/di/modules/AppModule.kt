/*
 * Copyright 2017 KG Soft
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kgurgul.cpuinfo.di.modules

import android.app.ActivityManager
import android.app.admin.DevicePolicyManager
import android.content.ContentResolver
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.content.res.Resources
import android.hardware.SensorManager
import android.view.WindowManager
import androidx.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Module which can provide all singletons
 *
 * @author kgurgul
 */
@Module(includes = [AppModuleBinds::class])
class AppModule {

    @Provides
    @Singleton
    fun provideResources(appContext: Context): Resources =
            appContext.resources

    @Provides
    @Singleton
    fun provideActivityManager(appContext: Context): ActivityManager =
            appContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

    @Provides
    @Singleton
    fun provideDevicePolicyManager(appContext: Context): DevicePolicyManager =
            appContext.getSystemService(Context.DEVICE_POLICY_SERVICE) as DevicePolicyManager

    @Provides
    @Singleton
    fun providePackageManager(appContext: Context): PackageManager =
            appContext.packageManager

    @Provides
    @Singleton
    fun provideContentResolver(appContext: Context): ContentResolver =
            appContext.contentResolver

    @Provides
    @Singleton
    fun provideWindowManager(appContext: Context): WindowManager =
            appContext.getSystemService(Context.WINDOW_SERVICE) as WindowManager

    @Provides
    @Singleton
    fun provideSensorManager(appContext: Context): SensorManager =
            appContext.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    @Provides
    @Singleton
    fun provideSharedPreferences(appContext: Context): SharedPreferences =
            PreferenceManager.getDefaultSharedPreferences(appContext)
}