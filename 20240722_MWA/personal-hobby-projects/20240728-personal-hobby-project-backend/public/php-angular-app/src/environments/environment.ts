const _getUserByIdEndpoint = function (userId: String): String {
  return `replace with user by id endpoint with id ${userId}`;
}

const _getAnimePaginatedEndpoint = function (page: number = 1, size: number = 10): String {
  return `replace with anime paginated endpoint with query params page = ${page} & size = ${size}`;
}

const _animeByIdEndpoint = function (animeId: String): String {
  return `replace with anime by id endpoint with id ${animeId}`;
}

const _getAnimeCharactersByAnimeIdEndpoint = function (animeId: String): String {
  return `replace with anime by id to fetch characters endpoint with id ${animeId}`;
}

const _animeCharacterByAnimeIdAndCharacterIdEndpoint = function (animeId: String, characterId: String): String {
  return `replace with anime by id to fetch characters by id endpoint with anime id ${animeId} and characterId ${characterId}`;
}

const _bearerToken = function (token: string) {
  return `Bearer ${token}`;
}

export const environment = Object.freeze({
  baseUrl: 'base url here',
  registerEndpoint: 'registration endpoint here',
  loginEndpoint: 'login endpoint here',
  getUserByIdEndpoint: _getUserByIdEndpoint,
  animeEndpoint: '/anime',
  getAnimePaginatedEndpoint: _getAnimePaginatedEndpoint,
  animeByIdEndpoint: _animeByIdEndpoint,
  getAnimeCharactersByAnimeIdEndpoint: _getAnimeCharactersByAnimeIdEndpoint,
  animeCharacterByAnimeIdAndCharacterIdEndpoint: _animeCharacterByAnimeIdAndCharacterIdEndpoint,
  accessToken: 'Access token string for local storage',
  authorizationHeader: 'Authorization header',
  bearerToken: _bearerToken,
  userRegisteredSuccessfullyMessage: 'User registered successfully. Please login now.',
  userRegistrationFailed: 'User registration failed.',
});
