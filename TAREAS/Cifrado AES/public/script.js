function isValidAESKey(key) {
  const len = key.length;
  return len === 16 || len === 24 || len === 32;
}

function generateRandomIV() {
  return CryptoJS.lib.WordArray.random(16);
}

function encryptMessage() {
  const message = document.getElementById('encryptText').value;
  const password = document.getElementById('encryptKey').value;

  if (!message || !password) {
    return alert("Mensaje y clave requeridos.");
  }

  if (!isValidAESKey(password)) {
    return alert("La clave debe tener 16, 24 o 32 caracteres.");
  }

  const iv = generateRandomIV();

  const encrypted = CryptoJS.AES.encrypt(message, CryptoJS.enc.Utf8.parse(password), {
    iv: iv,
    mode: CryptoJS.mode.CBC,
    padding: CryptoJS.pad.Pkcs7
  });

  const ivBase64 = CryptoJS.enc.Base64.stringify(iv);
  const encryptedBase64 = encrypted.toString();
  const finalOutput = ivBase64 + ':' + encryptedBase64;

  const blob = new Blob([finalOutput], { type: "text/plain;charset=utf-8" });
  saveAs(blob, "mensaje_cifrado.txt");
}

document.getElementById('decryptForm').addEventListener('submit', async function (e) {
  e.preventDefault();

  const fileInput = document.getElementById('decryptFile');
  const password = document.getElementById('decryptKey').value;

  if (!fileInput.files[0] || !password) {
    return alert("Archivo y clave requeridos.");
  }

  if (!isValidAESKey(password)) {
    return alert("Clave Incorrecta.");
  }

  const formData = new FormData();
  formData.append("file", fileInput.files[0]);

  const res = await fetch('/upload', {
    method: 'POST',
    body: formData
  });

  const encryptedContent = await res.text();

  try {
    const [ivBase64, encryptedBase64] = encryptedContent.split(':');

    const iv = CryptoJS.enc.Base64.parse(ivBase64);
    const decrypted = CryptoJS.AES.decrypt(encryptedBase64, CryptoJS.enc.Utf8.parse(password), {
      iv: iv,
      mode: CryptoJS.mode.CBC,
      padding: CryptoJS.pad.Pkcs7
    });

    const plaintext = decrypted.toString(CryptoJS.enc.Utf8);

    const resultDiv = document.getElementById('decryptedResult');
    resultDiv.classList.remove('d-none');
    resultDiv.querySelector('textarea').value = plaintext || 'Clave incorrecta o archivo corrupto.';
  } catch (err) {
    alert("Error al descifrar el archivo.");
  }
});
