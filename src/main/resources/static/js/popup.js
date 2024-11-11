// 로그인 팝업
function loginPopOpen() {
    closeOtherPopups('login');
    document.getElementById('loginOverlay').style.display = 'block';
    document.getElementById('login-popup').style.display = 'block';
}

function loginClosePopup() {
    document.getElementById('loginOverlay').style.display = 'none';
    document.getElementById('login-popup').style.display = 'none';
}
// 회원가입 완료 팝업
function signupPopOpen() {
    closeOtherPopups('signup');
    document.getElementById('signupOverlay').style.display = 'block';
    document.getElementById('signup-popup').style.display = 'block';
}

function signupClosePopup() {
    document.getElementById('signupOverlay').style.display = 'none';
    document.getElementById('signup-popup').style.display = 'none';
}
// 회원가입 실패 팝업
function signUpErrorPopOpen() {
    alert("회원가입에 실패했습니다. 다시 시도해주세요."); // 실패 팝업 함수
}
// 아이디 찾기 팝업
function findIdPopOpen() {
    closeOtherPopups('findId');
    document.getElementById('findIdOverlay').style.display = 'block';
    document.getElementById('findId-popup').style.display = 'block';
}

function findIdClosePopup() {
    document.getElementById('findIdOverlay').style.display = 'none';
    document.getElementById('findId-popup').style.display = 'none';
}
// 비밀번호 찾기 팝업
function findPwPopOpen() {
    closeOtherPopups('findPw');
    document.getElementById('findPwOverlay').style.display = 'block';
    document.getElementById('findPw-popup').style.display = 'block';
}

function findPwClosePopup() {
    document.getElementById('findPwOverlay').style.display = 'none';
    document.getElementById('findPw-popup').style.display = 'none';
}
// 비밀번호 재설정 팝업
function resetPwPopOpen() {
    closeOtherPopups('resetPw');
    document.getElementById('resetPwOverlay').style.display = 'block';
    document.getElementById('resetPw-popup').style.display = 'block';
}

function resetPwClosePopup() {
    document.getElementById('resetPwOverlay').style.display = 'none';
    document.getElementById('resetPw-popup').style.display = 'none';
}
// 작가 신청 팝업
function authorPopOpen() {
    closeOtherPopups('author');
    document.getElementById('authorOverlay').style.display = 'block';
    document.getElementById('author-popup').style.display = 'block';
}

function authorClosePopup() {
    document.getElementById('authorOverlay').style.display = 'none';
    document.getElementById('author-popup').style.display = 'none';
}
// 전체 주문 팝업
function totalOrderPopOpen() {
    closeOtherPopups('totalOrder');
    document.getElementById('totalOrderOverlay').style.display = 'block';
    document.getElementById('totalOrder-popup').style.display = 'block';
}

function totalOrderClosePopup() {
    document.getElementById('totalOrderOverlay').style.display = 'none';
    document.getElementById('totalOrder-popup').style.display = 'none';
}

// 다른 팝업 닫기
function closeOtherPopups(except) {
    const popups = [
        { id: 'login', overlayId: 'loginOverlay' },
        { id: 'signup', overlayId: 'signupOverlay' },
        { id: 'findId', overlayId: 'findIdOverlay' },
        { id: 'findPw', overlayId: 'findPwOverlay' },
        { id: 'resetPw', overlayId: 'resetPwOverlay'},
        { id: 'author', overlayId: 'authorOverlay'},
        { id: 'totalOrder', overlayId: 'totalOrderOverlay'}
    ];

    popups.forEach(popup => {
        if (popup.id !== except) {
            const overlay = document.getElementById(popup.overlayId);
            const popupElement = document.getElementById(`${popup.id}-popup`);

            if (overlay) {
                overlay.style.display = 'none';
            }
            if (popupElement) {
                popupElement.style.display = 'none';
            }
        }
    });
}
