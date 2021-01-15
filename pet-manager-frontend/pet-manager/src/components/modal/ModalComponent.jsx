import React from "react";
import "./ModalComponent.css";
import { addExtraProps } from "../../utils/ComponentManipulation.js";

const ModalComponent = ({ isOpen, content, onClose }) => {
  const closeModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.add("hidden");
    overlay.classList.add("hidden");
    onClose();
  };

  const openModal = () => {
    const addPet = document.querySelector(".modal");
    const overlay = document.querySelector(".overlay");
    addPet.classList.remove("hidden");
    overlay.classList.remove("hidden");
    overlay.addEventListener("click", closeModal);
  };

  const contentWithAddedProp = addExtraProps(content, {
    closeModal: closeModal,
  });

  if (isOpen) {
    openModal();
  }

  return (
    <div>
      <div className="modal hidden">
        <button onClick={closeModal}>&times;</button>
        {contentWithAddedProp}
      </div>

      <div className="overlay hidden"></div>
    </div>
  );
};

export default ModalComponent;
