import requsest from "../js/headerreq"
export function cishi(searchsubjectvalue) {
    return requsest({
        url: "http://localhost:3001users/search",
        method: "get",
        params: {
            searcha: searchsubjectvalue
        }
    })
}