const API_KEY = "d0151fc56-ecc2-4c03-b60a-ba520d9668fb";

//get all the upcomming matches

export const getMatches = () => {
  const url = `https://api.cricapi.com/v1/cricScore?apikey=${API_KEY}`;

  return fetch(url).then((response) => response.json()).catch((error) => console.log("ERROR :", error))
};

//load match details

export const getMatchDetail = (id) => {
  const url = `https://cricapi.com/api/fantasySummary?apikey=${API_KEY}&unique_id=${id}`;

  return fetch(url).then(response => response.json()).catch(error=>console.log(error));
};
