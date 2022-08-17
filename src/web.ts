import { WebPlugin } from '@capacitor/core';

import type { LiverampPlugin } from './definitions';

export class LiverampWeb extends WebPlugin implements LiverampPlugin {
  initialize(): Promise<void> {
    throw new Error('Method not implemented.');
  }
  getEnvelope(): Promise<{ envelope: string }> {
    throw new Error('Method not implemented.');
  }
  setHasConsentForNoLegislation(): Promise<void> {
    throw new Error('Method not implemented.');
  }
}
