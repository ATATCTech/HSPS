package com.atatctech.hsps;

import com.atatctech.hsps.verification.Signed;
import org.jetbrains.annotations.Nullable;

@Signed("KmmLlCogjpsVVRdbkchtiZI4DlINUDZWJG3bIgyWXZuczEZ9zh+zP6zZI+WcZ5LvqjajVUVgxB/zp39yeQ+eKrBvja1c13Bupns9UvrJAQUVR3Uam8uHOnvhVIdVeNk7uKxOYJyDh8PE2K/0uag4HymgMikBQ5jy2wqAV8FItH/XZdjqRFANQ2G/U6fDDspjrIbeifr+nML5me/R+0nUY5RHdd1NTiGXjgEvLFj3OIDiO90FNhuIy7wV9NxA9TyNcFB94aANYiqe4oyYUD5rgpPV+Xzqs+gWTAO4h/W0YSOYYYeABYtDpOtv+N+iCC2OP4hqHSZowxczGzi4QAN9TA==")
public class TestPlugin implements Plugin {
    public static void run() {
        System.out.println("test");
    }

    @Override
    public void initialize(@Nullable Object... args) {
    }
}
