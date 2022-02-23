package com.eddrix.project.evoting.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.eddrix.project.evoting.R;

import java.util.Objects;


public class MyDialogLoader extends DialogFragment {
    LottieAnimationView lottieAnimationView;
    TextView Msg;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.dialog_loader,container,false);
        Msg=view.findViewById(R.id.textView9);
        lottieAnimationView=view.findViewById(R.id.lottie_progress_center);
        assert getArguments() != null;
        String msg=getArguments().getString("MSG");
        Msg.setText(msg);
        lottieAnimationView.playAnimation();
        lottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
        Objects.requireNonNull(getDialog()).setCanceledOnTouchOutside(false);

        setCancelable(false);
        return view;
    }


}
