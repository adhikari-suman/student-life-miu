const _getUserByIdEndpoint = function (userId: String): String {
  return `/users/${userId}`;
}

const _getAnimePaginatedEndpoint = function (page: number = 1, size: number = 10): String {
  return `/anime?page=${page}&size=${size}`;
}

const _animeByIdEndpoint = function (animeId: String): String {
  return `/anime/${animeId}`;
}

const _getAnimeCharactersByAnimeIdEndpoint = function (animeId: String): String {
  return `/anime/${animeId}/characters`;
}

const _animeCharacterByAnimeIdAndCharacterIdEndpoint = function (animeId: String, characterId: String): String {
  return `/anime/${animeId}/characters/${characterId}`;
}

export const environment = Object.freeze({
  baseUrl: 'http://localhost:3000/api/v1',
  registerEndpoint: '/users',
  loginEndpoint: '/users/authenticate',
  getUserByIdEndpoint: _getUserByIdEndpoint,
  getAnimePaginatedEndpoint: _getAnimePaginatedEndpoint,
  animeByIdEndpoint: _animeByIdEndpoint,
  getAnimeCharactersByAnimeIdEndpoint: _getAnimeCharactersByAnimeIdEndpoint,
  animeCharacterByAnimeIdAndCharacterIdEndpoint: _animeCharacterByAnimeIdAndCharacterIdEndpoint,
});
