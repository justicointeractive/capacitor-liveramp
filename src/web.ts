import { WebPlugin } from '@capacitor/core';

import type { LiverampPlugin } from './definitions';

export class LiverampWeb extends WebPlugin implements LiverampPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
