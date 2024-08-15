export class Character {
  _id?: string;
  name: string;
  characteristics: string[];

  constructor(name: string, characteristics: string[], _id?: string) {
    this._id = _id;
    this.name = name;
    this.characteristics = characteristics;
  }
}
