import {Character} from "./character.model";

export class Anime {
  public _id?: string;  // Optional property
  public name: string;
  public characters: Character[];
  public studio: string;
  public releaseDate: Date;

  constructor(
    releaseDate: Date,
    name: string,
    characters: Character[],
    studio: string,
    _id?: string,
  ) {
    this._id = _id;
    this.name = name;
    this.studio = studio;
    this.characters = characters;
    this.releaseDate = releaseDate;
  }
}
