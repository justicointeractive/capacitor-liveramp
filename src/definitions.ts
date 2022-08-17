export interface LiverampPlugin {
  setHasConsentForNoLegislation(options: {
    hasConsentForNoLegislation: boolean;
  }): Promise<void>;
  initialize(options: { appId: string; isTestMode: boolean }): Promise<void>;
  getEnvelope(options: {
    type: string;
    identifier: string;
  }): Promise<{ envelope: string }>;
}
