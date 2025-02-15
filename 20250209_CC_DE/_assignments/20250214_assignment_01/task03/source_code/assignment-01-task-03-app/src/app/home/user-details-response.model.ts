export interface UserProfile {
  name: String;
  image: String;
  traits: [String];
  personality: [String];
}

export interface UserDetails {
    profile: UserProfile;
    friends: [UserProfile];
}

export interface UserDetailsResponse {
  userDetails: UserDetails;
}

