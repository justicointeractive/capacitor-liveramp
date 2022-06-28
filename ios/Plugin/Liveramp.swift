import Foundation
import LRAtsSDK

@objc public class Liveramp: NSObject {
    @objc public func initialize(_ appId: String, completionHandler: @escaping (_ success: Bool, _ error: Error?) -> Void) {
        let lrAtsConfiguration = LRAtsConfiguration(appId: appId);
        LRAts.shared.initialize(with: lrAtsConfiguration, completion: completionHandler);
    }
    @objc public func getEnvelope(_ type: String, identifier: String, completionHandler: @escaping (_ success: LREnvelope?, _ error: Error?) -> Void) {
        let lrEmailIdentifier = LREmailIdentifier(identifier);
        LRAts.shared.getEnvelope(lrEmailIdentifier, completion: completionHandler);
    }
}
