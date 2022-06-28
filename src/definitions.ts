export interface LiverampPlugin {
  initialize(options: { appId: string; isTestMode: boolean }): Promise<void>;
  getEnvelope(options: {
    type: string;
    identifier: string;
  }): Promise<{ envelope: string }>;
}
