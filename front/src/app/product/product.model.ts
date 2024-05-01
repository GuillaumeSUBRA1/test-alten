import { Sort } from "app/shared/ui/list/search.model";

export class Product {
    id: number;
    code: string;
    name: string;
    description: string;
    price: number;
    quantity: number;
    inventoryStatus: string;
    category: string;
    image?: string;
    rating?: number;
  }
  

export const stock=[
  "OUTOFSTOCK",
  "INSTOCK",
  "LOWSTOCK"
];

export const categories=[
  "ELECTRONICS",
  "ACCESSORIES",
  "FITNESS",
  "CLOTHING"
];

export const tableColumns=[
  'id',
  'code',
  'name',
  'description',
  'image',
  'price',
  'category',
  'quantity',
  'inventoryStatus',
  'rating'
]

export const sortKeyList=[
  "price", 
  "name", 
  "quantity", 
  "inventoryStatus", 
  "category", 
  "rating"
];

export const sortOptionList = [
  { label: 'Name', value: Sort.asc + '-name' },
  { label: 'Price', value: Sort.asc + '-price' },
  { label: 'Quantity', value: Sort.asc + '-quantity' },
  { label: 'Inventory status', value: Sort.asc + '-inventoryStatus' },
  { label: 'Category', value: Sort.asc + '-category' },
  { label: 'Rating', value: Sort.asc + '-rating' }
];
