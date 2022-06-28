import Foundation

@objc public class Liveramp: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
