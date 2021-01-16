export const getTimeStringFromDateTimeString = (dateTimeString) => {
  const [, timeWithSeconds] = dateTimeString.split("T");
  const time = timeWithSeconds.split(":", 2).join(":");

  return time;
};
