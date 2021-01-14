export const getTimeStringFromDateTimeString = (dateTimeString) => {
  const [, timeWithSeconds] = dateTimeString.split("T");
  const timeString = timeWithSeconds.split(":", 2).join(":");

  return timeString;
};
