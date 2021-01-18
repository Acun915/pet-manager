export const getAllPets = async () => {
  const response = await fetch(`http://localhost:8080/rest/pets`);
  const data = await response.json();
  return data;
};

export const addPet = (pet) => {
  fetch("http://localhost:8080/rest/pets", {
    method: "POST",
    body: JSON.stringify(pet),
    headers: { "Content-Type": "application/json" },
  });
};

export const addPetScheduledEvent = (petId, scheduledEvent) => {
  fetch(`http://localhost:8080/rest/pets/${petId}/scheduledEvents`, {
    method: "POST",
    body: JSON.stringify(scheduledEvent),
    headers: { "Content-Type": "application/json" },
  });
};

export const addCompletedEvent = (petId, completedEvent) => {
  fetch(
    `http://localhost:8080/rest/pets/${petId}/scheduledEvents/completedEvents`,
    {
      method: "POST",
      body: JSON.stringify(completedEvent),
      headers: { "Content-Type": "application/json" },
    }
  );
};

export const deleteCompletedEventById = (petId, id) => {
  fetch(
    `http://localhost:8080/rest/pets/${petId}/scheduledEvents/completedEvents/${id}`,
    {
      method: "DELETE",
    }
  );
};
