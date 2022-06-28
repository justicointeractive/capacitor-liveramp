package com.justicointeractive.capacitor.liveramp;

import androidx.annotation.Nullable;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.liveramp.ats.LRError;
import com.liveramp.ats.callbacks.LRCompletionHandlerCallback;
import com.liveramp.ats.callbacks.LREnvelopeCallback;
import com.liveramp.ats.model.Envelope;

@CapacitorPlugin(name = "Liveramp")
public class LiverampPlugin extends Plugin {

    private Liveramp implementation = new Liveramp();

    @PluginMethod
    public void initialize(PluginCall call) {
        String appId = call.getString("appId");

        implementation.initialize(
            appId,
            new LRCompletionHandlerCallback() {
                @Override
                public void invoke(boolean success, @Nullable LRError lrError) {
                    if (success) {
                        // SDK ready for use
                        call.resolve();
                    } else {
                        // SDK failed to initialize
                        call.reject(lrError.toString());
                    }
                }
            }
        );
    }

    @PluginMethod
    public void getEnvelope(PluginCall call) {
        String type = call.getString("type");
        String identifier = call.getString("identifier");

        implementation.getEnvelope(
            type,
            identifier,
            new LREnvelopeCallback() {
                @Override
                public void invoke(@Nullable Envelope envelope, @Nullable LRError lrError) {
                    if (envelope != null) {
                        // SDK ready for use
                        JSObject ret = new JSObject();
                        ret.put("envelope", envelope.getEnvelope());
                        call.resolve(ret);
                    } else {
                        // SDK failed to initialize
                        call.reject(lrError.toString());
                    }
                }
            }
        );
    }
}
