import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(LiverampPlugin)
public class LiverampPlugin: CAPPlugin {
    private let implementation = Liveramp()

    @objc func initialize(_ call: CAPPluginCall) {
        let appId = call.getString("appId") ?? ""
        let isTestMode = call.getBool("isTestMode") ?? false
        implementation.initialize(appId, isTestMode: isTestMode) { success, error in
            if success {
                call.resolve()
            } else {
                call.reject("SDK init error: \(String(describing: error))")
            }
        }
    }

    @objc func getEnvelope(_ call: CAPPluginCall) {
        let type = call.getString("type") ?? ""
        let identifier = call.getString("identifier") ?? ""
        implementation.getEnvelope(type, identifier: identifier) { result, error in
            guard let envelope = result?.envelope else {
                call.reject("Couldn't retrieve envelope. Error: \(error!)")
                return
            }
            print("Received envelope: \(envelope)")
            call.resolve([
                "envelope": envelope
            ]);
        }
    }
}
