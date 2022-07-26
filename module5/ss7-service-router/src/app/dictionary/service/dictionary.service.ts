import {Injectable} from '@angular/core';
import {Dictionary} from '../model/dictionary';

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: Dictionary[] = [];

  constructor() {
    this.dictionary.push({word: 'Hello', mean: 'chào'},
      {word: 'Dog', mean: 'Chó'},
      {word: 'Cat', mean: 'Mèo'},
      {word: 'Bird', mean: 'Chim'},
      {word: 'Fish', mean: 'Cá'});
  }

  findAll() {
    return this.dictionary;
  }

  findWord(word: string) {
    return this.dictionary.filter(data => data.word === word);
  }
}
