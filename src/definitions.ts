export interface LiverampPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
