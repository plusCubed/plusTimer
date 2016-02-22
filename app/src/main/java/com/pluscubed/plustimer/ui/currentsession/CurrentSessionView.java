package com.pluscubed.plustimer.ui.currentsession;

import android.app.Activity;

import com.pluscubed.plustimer.MvpView;
import com.pluscubed.plustimer.ui.currentsessiontimer.CurrentSessionTimerFragment;
import com.pluscubed.plustimer.ui.solvelist.SolveListFragment;

public interface CurrentSessionView extends MvpView {

    void supportInvalidateOptionsMenu();

    CurrentSessionTimerFragment getCurrentSessionTimerFragment();

    SolveListFragment getSolveListFragment();

    Activity getContextCompat();
}