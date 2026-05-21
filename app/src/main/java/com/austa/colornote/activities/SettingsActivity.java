package com.austa.colornote.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import com.google.android.material.appbar.MaterialToolbar;
import com.austa.colornote.R;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        View mainView = findViewById(R.id.settings_root);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0);
                return insets;
            });
        }

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationOnClickListener(v -> finish());
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new SettingsFragment())
                .commit();
    }

    public static class SettingsFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.preferences, rootKey);

            ListPreference themePref = findPreference("theme");
            if (themePref != null) {
                themePref.setOnPreferenceChangeListener((preference, newValue) -> {
                    applyTheme((String) newValue);
                    return true;
                });
            }

            Preference share = findPreference("share");
            if (share != null) {
                share.setOnPreferenceClickListener(pref -> {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, "Check out ColorNote: https://play.google.com/store/apps/details?id=" + requireContext().getPackageName());
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                    return true;
                });
            }

            Preference rate = findPreference("rate");
            if (rate != null) {
                rate.setOnPreferenceClickListener(pref -> {
                    Uri uri = Uri.parse("market://details?id=" + requireContext().getPackageName());
                    Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(goToMarket);
                    return true;
                });
            }

            Preference contact = findPreference("contact");
            if (contact != null) {
                contact.setOnPreferenceClickListener(pref -> {
                    Intent email = new Intent(Intent.ACTION_SENDTO);
                    email.setData(Uri.parse("mailto:"));
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"austaserviceprivate@gmail.com"});
                    email.putExtra(Intent.EXTRA_SUBJECT, "ColorNote Feedback");
                    startActivity(Intent.createChooser(email, "Send Email"));
                    return true;
                });
            }

            Preference privacy = findPreference("privacy");
            if (privacy != null) {
                privacy.setOnPreferenceClickListener(pref -> {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://austaservice.blogspot.com/p/privacy-policy.html"));
                    startActivity(intent);
                    return true;
                });
            }

            Preference about = findPreference("about");
            if (about != null) {
                about.setOnPreferenceClickListener(pref -> {
                    startActivity(new Intent(requireContext(), AboutActivity.class));
                    return true;
                });
            }
        }

        private void applyTheme(String theme) {
            switch (theme) {
                case "light":
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    break;
                case "dark":
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    break;
                default:
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                    break;
            }
        }
    }
}