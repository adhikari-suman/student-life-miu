export const handler = async (event) => {
  const personalDetails = {name: 'Suman Adhikari', 
  characteristics: ['Slim', 'Tall-enough', 'Loves Dota2 and has no girlfriend.', 'CANCER SUPPORT in Dota2','AA and WW carry', 'Voted "Scaredy-cat" by Gam Hpang'], 
  personality: ['Friendly', 'Kind', 'Gamer-frenzy']
};

  const friends = [
    {
      name: 'Sagar Maharjan', 
      characteristics: ['Strong', 'Fit', 'Tall'], 
      personality: ['Friendly', 'Kind'] 
    },
    {
      name: 'Aung Kyaw Myint', 
      characteristics: ['Slim', 'Asian-White', 'Tall', 'Crazy about noodles'], 
      personality: ['Friendly', 'Kind', 'Lazy']
    },
    {
      name: 'Gam Hpang', 
      characteristics: ['Slim', 'Tall', 'Reserved', 'Loves Dota2 and his short girlfriend only', 'Injoker'], 
      personality: ['Friendly', 'Kind', 'Gamer-frenzy']},
    {
      name: 'Htet Yadanar Oo', 
      characteristics: ['Slim', 'Short', 'Reserved', 'Loves  her tall boyfriend only'], 
      personality: ['Friendly', 'Kind', 'Silly', 'Crybaby']
    }
  ];

  const details = {
    personalDetails: personalDetails,
    friends: friends
  }

  const response = { statusCode: 200, body: {details: details},};
  return response;
};
