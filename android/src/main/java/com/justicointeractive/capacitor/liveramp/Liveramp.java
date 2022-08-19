package com.justicointeractive.capacitor.liveramp;

import com.liveramp.ats.LRAtsManager;
import com.liveramp.ats.callbacks.LRCompletionHandlerCallback;
import com.liveramp.ats.callbacks.LREnvelopeCallback;
import com.liveramp.ats.model.LRAtsConfiguration;
import com.liveramp.ats.model.LREmailIdentifier;

public class Liveramp {

    public void initialize(String appId, Boolean isTestMode, LRCompletionHandlerCallback initCallback) {
        LRAtsManager.INSTANCE.initialize(new LRAtsConfiguration(appId, isTestMode, false), initCallback);
    }

    public void getEnvelope(String type, String identifier, LREnvelopeCallback envelopeCallback) {
        LREmailIdentifier id = new LREmailIdentifier(identifier);
        LRAtsManager.INSTANCE.getEnvelope(id, envelopeCallback);
    }

    public void setHasConsentForNoLegislation(Boolean hasConsentForNoLegislation) {
        LRAtsManager.INSTANCE.setHasConsentForNoLegislation(hasConsentForNoLegislation);
    }
}
