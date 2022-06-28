import { registerPlugin } from '@capacitor/core';

import type { LiverampPlugin } from './definitions';

const Liveramp = registerPlugin<LiverampPlugin>('Liveramp', {
  web: () => import('./web').then(m => new m.LiverampWeb()),
});

export * from './definitions';
export { Liveramp };
