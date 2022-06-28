export interface LiverampPlugin {
  initialize(options: { appId: string }): Promise<void>;
  getEnvelope(options: {
    type: string;
    identifier: string;
  }): Promise<{ envelope: string }>;
}
