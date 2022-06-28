package com.justicointeractive.capacitor.liveramp;

import android.util.Log;

import com.liveramp.ats.LRAtsManager;
import com.liveramp.ats.callbacks.LRCompletionHandlerCallback;
import com.liveramp.ats.callbacks.LREnvelopeCallback;
import com.liveramp.ats.model.LRAtsConfiguration;
import com.liveramp.ats.model.LREmailIdentifier;

public class Liveramp {

    public void initialize(String appId, LRCompletionHandlerCallback initCallback) {
        LRAtsManager.INSTANCE.initialize(new LRAtsConfiguration(appId, true), initCallback);
    }

    public void getEnvelope(String type, String identifier, LREnvelopeCallback envelopeCallback) {
        LREmailIdentifier id = new LREmailIdentifier(identifier);
        LRAtsManager.INSTANCE.getEnvelope(id, envelopeCallback);
    }
}
