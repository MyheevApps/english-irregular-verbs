package ru.max.irvefree.ui.settings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import ru.max.irvefree.R;

public class SettingsFragment extends Fragment implements View.OnClickListener {

    TextView tvFeedback, tvSendEmail, tvAboutApp, tvDeliteAbs;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        tvFeedback = (TextView) root.findViewById(R.id.tvFeedback);
        tvSendEmail = (TextView) root.findViewById(R.id.tvSendEmail);
        tvAboutApp = (TextView) root.findViewById(R.id.tvAboutApp);
        tvDeliteAbs = (TextView) root.findViewById(R.id.tvDeliteAbs);

        tvAboutApp.setOnClickListener(this);
        tvSendEmail.setOnClickListener(this);
        tvFeedback.setOnClickListener(this);
        tvDeliteAbs.setOnClickListener(this);
        return root;
    } 

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tvAboutApp:
                intent = new Intent("ru.max.irvefree.AboutProgramActivity");
                startActivity(intent);
                break;
            case R.id.tvFeedback:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.max.irvefree"));
                startActivity(intent);
                break;
            case R.id.tvSendEmail:
                intent = new Intent("ru.max.irvefree.FeedbackActivity");
                startActivity(intent);
                break;
            case R.id.tvDeliteAbs:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=ru.max.irvi"));
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
