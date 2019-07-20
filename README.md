# appupdater
Update an Android app by calling the updateApp function from an Activity.

```
/**
 * Updates the app to a newer version.
 *
 * @param versionCode BuildConfig.VERSION_CODE of the calling app.
 * @param metaUrl Url pointing to the output.json file from the Gradle build.
 * @param apkUrl Url pointing to the APK file.
 * @param changelogUrl Url pointing to a file with the changelog.
 */
updateApp(
    activity: Activity,
    versionCode: Int,
    metaUrl: String,
    apkUrl: String,
    changelogUrl: String)
```
