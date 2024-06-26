const url = "http://localhost:8080/api/products/purchaselist";

function sessionCurrent() {
  axios
    .get("http://localhost:8080/user/current", { withCredentials: true })
    .then((response) => {
      console.log("데이터: ", response.data);
      if (response.status == 200) {
        const userId = response.data.userId;
        const authority = response.data.authority[0].authority;
        let cartItems = JSON.parse(localStorage.getItem(userId));
        if (cartItems) {
          displayCart(cartItems);
          const data = cartItems.map((game) => {
            // Purchase 객체를 만들어서 리턴
            return {
              game: game,
              user: { userId: userId, authority: { authorityName: authority } }
            };
          })
          document
            .querySelector(".purchaseBtn")
            .addEventListener("click", () => {
              if (confirm("진짜 구매하시겠습니까?")) {
                axios
                  .post(url, data, { withCredentials: true })
                  .then((response) => {
                    console.log("데이터: ", response.data);
                    localStorage.removeItem(userId);
                    window.location.reload();
                  })
                  .catch((error) => {
                    console.log("에러 발생: ", error);
                  });
              }
            });
        }
      }
    })

    .catch((error) => {
      console.log("에러 발생: ", error);
      alert("로그인해주세요.");
    });
}

function displayCart(games, userId){
  const tbody = document.querySelector(".cart-body");
  tbody.innerHTML = "";
  let totalPrice = 0;
  games.forEach((data, index)=>{
    // 태그 요소 생성
    const tr = document.createElement("tr");
    const imgtd = document.createElement("td");
    const title = document.createElement("td");
    const genre = document.createElement("td");
    const price = document.createElement("td");
    const deleteBtn = document.createElement("td");
    const img = document.createElement("img");
    // 클래스이름 생성
    imgtd.classList.add("imgtd");
    img.classList.add("image");
    deleteBtn.classList.add("deleteBtn");
    // 태그 속성 추가
    img.src = data.image;
    title.textContent = data.title;
    genre.textContent = data.genre;
    price.textContent = data.price + "원";
    deleteBtn.textContent = "삭제버튼";
    // appendChild 부모 자식 위치 설정
    // appendChild는 항상 가장 아래에다 생성한다.
    imgtd.appendChild(img);
    tr.appendChild(imgtd);
    tr.appendChild(title);
    tr.appendChild(genre);
    tr.appendChild(price);
    tr.appendChild(deleteBtn);
    tbody.appendChild(tr);

    totalPrice = totalPrice + data.price;

     deleteBtn.addEventListener("click", () => {
        if (confirm("장바구니에서 삭제하시겠습니까?")) {
           games.splice(index, 1);
           localStorage.removeItem(userId, JSON.stringify(games));
           displayCart (userId, games);
           }
        });
      })

  document.querySelector(".totalprice").textContent = "총 " + totalPrice + "원";
}

// 페이지 로딩시에 즉시 세션여부 확인
sessionCurrent();