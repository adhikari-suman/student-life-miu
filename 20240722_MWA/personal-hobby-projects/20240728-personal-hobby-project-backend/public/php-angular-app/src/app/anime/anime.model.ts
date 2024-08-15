import {Character} from "./character.model";

export class Anime {
  public _id?: string;  // Optional property
  public name: string;
  public characters: Character[];
  public releaseDate: Date;

  constructor(
    releaseDate: Date,
    name: string,
    characters: Character[],
    _id?: string,
  ) {
    this._id = _id;
    this.name = name;
    this.characters = characters;
    this.releaseDate = releaseDate;
  }
}
