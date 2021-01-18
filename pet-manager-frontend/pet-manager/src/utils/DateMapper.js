export const getTimeStringFromDateTimeString = (dateTimeString) => {
  const [, timeWithSeconds] = dateTimeString.split("T");
  const time = timeWithSeconds.split(":", 2).join(":");

  return time;
};

export const getDateStringFromDateTimeString = (dateTimeString) => {
  const [date] = dateTimeString.split("T");

  return date;
};
